package com.OnlineResult.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.OnlineResult.Entity.ExamFormat;
import com.OnlineResult.Entity.ExamGraceMarks;
import com.OnlineResult.Entity.ExamMarks;
import com.OnlineResult.Entity.Marks;
import com.OnlineResult.Entity.PracticalGraceMarks;
import com.OnlineResult.Model.ExamFormatModel;
import com.OnlineResult.Model.ExamGraceMarksModel;
import com.OnlineResult.Model.ExamMarksModel;
import com.OnlineResult.Model.PracticalGraceMarksModel;
import com.OnlineResult.Repository.ExamMarksRepository;
import com.OnlineResult.Repository.GraceMarksRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class ExamMarksService implements ExamMarksServiceInterface {

	private Float subject1TotalMarks, subject2TotalMarks, subject3TotalMarks, subject4TotalMarks, subject5TotalMarks,
			subject1PracticalMarks, subject2PracticalMarks, subject3PracticalMarks, subject4PracticalMarks,
			subject5PracticalMarks, internal1Total, internal2Total, practicalTotal, theoryTotal, passingPercentage,
			totalFormat, totalCalculatedValue = 0.0f, subject1Grace = null, subject2Grace = null, subject3Grace = null,
			subject4Grace = null, subject5Grace = null, totalGivenGraceMarks = 0f;
	private String url;
	private ExamFormatModel examFormatModel;
	@Autowired
	private RestTemplate restTemplate;
	private Map<String, Float> lessMarksMap = new HashMap<String, Float>();

	@Autowired
	private ExamMarksRepository examMarksRepository;

	@Autowired
	private GraceMarksRepo graceMarksRepo;

	@Override
	public void addExamMarks(ExamMarksModel examMarksModel) {
		Gson gson = new Gson();
		String json = gson.toJson(examMarksModel);
		ExamMarks examMarks = gson.fromJson(json, ExamMarks.class);
		examMarksRepository.save(examMarks);
	}

	@Override
	public List<ExamMarksModel> getExamMarks() {

		Iterable<ExamMarks> itExamMarks = examMarksRepository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itExamMarks);
		List<ExamMarksModel> listExamMarksModel = gson.fromJson(json, new TypeToken<List<ExamMarksModel>>() {
		}.getType());
		return listExamMarksModel;
	}

	@Override
	public List<ExamMarksModel> getExamMarksByYearSemester(int year, String semester, String month, String type,
			String pattern) {
		Iterable<ExamMarks> itExamMarks = examMarksRepository.findByYearAndSemesterAndMonthAndTypeAndPattern(year,
				semester, month, type, pattern);
		Gson gson = new Gson();
		String json = gson.toJson(itExamMarks);
		List<ExamMarksModel> listExamMarksModel = gson.fromJson(json, new TypeToken<List<ExamMarksModel>>() {
		}.getType());
//		CheckAndAddGrace(year, semester, month, pattern, "Dinesh123");
		return listExamMarksModel;
	}

	@Override
	public List<ExamMarksModel> CheckAndAddGrace(int year, String semester, String month, String pattern,
			String Unicode) {
		Iterable<ExamMarks> itExamMarks = examMarksRepository
				.findByYearAndSemesterAndMonthAndPatternAndStudentUnicode(year, semester, month, pattern, Unicode);
		Gson gson = new Gson();
		String json = gson.toJson(itExamMarks);
		List<ExamMarksModel> listExamMarksModel = gson.fromJson(json, new TypeToken<List<ExamMarksModel>>() {
		}.getType());

		ExamMarksModel internal1 = null, internal2 = null, theory = null, practical = null;
		for (ExamMarksModel itExamMarksModel : listExamMarksModel) {
			if (itExamMarksModel.getType().equals("internal1"))
				internal1 = itExamMarksModel;
			if (itExamMarksModel.getType().equals("internal2"))
				internal2 = itExamMarksModel;
			if (itExamMarksModel.getType().equals("theory"))
				theory = itExamMarksModel;
			if (itExamMarksModel.getType().equals("practical"))
				practical = itExamMarksModel;

		}
		// get the total marks of the per subject
		GetTheTotalMarks(internal1, internal2, theory, practical);

		// get the marks from the Format
		url = "http://localhost:8762/ExamFormatInfo/ExamFormat/getExamFormat";
		examFormatModel = restTemplate.getForObject(url + year, ExamFormatModel.class);
//		ResponseEntity<ExamFormatModel> response=restTemplate.exchange(url, HttpMethod.GET, requestEntity, responseType)
		GetTotalFormatMarks(examFormatModel);
		CheckFormatMarks();
		for (Map.Entry<String, Float> entry : lessMarksMap.entrySet()) {
			totalCalculatedValue += entry.getValue();
		}
		System.out.println(totalCalculatedValue);
		if (totalCalculatedValue <= 200) {
			// give the grace
			if (lessMarksMap.get("subject1TotalMarks") != null) {
				subject1Grace = (totalFormat * (passingPercentage / 100)) - subject1TotalMarks;
				System.out.println("subject1 " + subject1Grace);
			}
			if (lessMarksMap.get("subject2TotalMarks") != null) {
				subject2Grace = (totalFormat * (passingPercentage / 100)) - subject2TotalMarks;
				System.out.println("subject2 " + subject2Grace);
			}
			if (lessMarksMap.get("subject3TotalMarks") != null) {
				subject3Grace = (totalFormat * (passingPercentage / 100)) - subject3TotalMarks;
				System.out.println("subject3 " + subject3Grace);
			}
			if (lessMarksMap.get("subject4TotalMarks") != null) {
				subject4Grace = (totalFormat * (passingPercentage / 100)) - subject4TotalMarks;
				System.out.println("subject4 " + subject4Grace);
			}
			if (lessMarksMap.get("subject5TotalMarks") != null) {
				subject5Grace = (totalFormat * (passingPercentage / 100)) - subject5TotalMarks;
				System.out.println("subject5 " + subject5Grace);
			}

		}
		if (subject1Grace != null) {
			totalGivenGraceMarks += subject1Grace;
		}
		if (subject2Grace != null) {
			totalGivenGraceMarks += subject2Grace;
		}
		if (subject3Grace != null) {
			totalGivenGraceMarks += subject3Grace;
		}
		if (subject4Grace != null) {
			totalGivenGraceMarks += subject4Grace;
		}
		if (subject5Grace != null) {
			totalGivenGraceMarks += subject5Grace;
		}

		// remove grace marks if total given grace Marks is greater than 7
		if (totalGivenGraceMarks > 7f) {
			subject1Grace = null;
			subject2Grace = null;
			subject3Grace = null;
			subject4Grace = null;
			subject5Grace = null;
		}

		if (subject1Grace != null || subject2Grace != null || subject3Grace != null || subject4Grace != null
				|| subject4Grace != null) {
			ExamGraceMarks examGraceMarks = new ExamGraceMarks();
			Marks marks = new Marks();
			if (subject1Grace != null)
				marks.setSubject1(subject1Grace);
			if (subject2Grace != null)
				marks.setSubject2(subject2Grace);
			if (subject3Grace != null)
				marks.setSubject3(subject3Grace);
			if (subject4Grace != null)
				marks.setSubject4(subject4Grace);
			if (subject5Grace != null)
				marks.setSubject5(subject5Grace);

			examGraceMarks.setMarks(marks);
			examGraceMarks.setMonth(month);
			examGraceMarks.setPattern(pattern);
			examGraceMarks.setSemester(semester);
			examGraceMarks.setStudentUnicode(Unicode);
			examGraceMarks.setYear(year);
			PracticalGraceMarks practicalGraceMarks = new PracticalGraceMarks();
			practicalGraceMarks.setSubject1(4);
			practicalGraceMarks.setSubject2(4);
			practicalGraceMarks.setSubject3(7);
			practicalGraceMarks.setSubject4(8);
			practicalGraceMarks.setSubject5(9);

			examGraceMarks.setPracticalGraceMarks(practicalGraceMarks);

			graceMarksRepo.save(examGraceMarks);
		}
		return listExamMarksModel;

	}

	public void GetTotalFormatMarks(ExamFormatModel examFormatModel) {
		internal1Total = Float.parseFloat(String.valueOf(examFormatModel.getInternal1()));
		internal2Total = Float.parseFloat(String.valueOf(examFormatModel.getInternal2()));
		theoryTotal = Float.parseFloat(String.valueOf(examFormatModel.getExternal()));
		practicalTotal = Float.parseFloat(String.valueOf(examFormatModel.getPractical()));
		passingPercentage = Float.parseFloat(String.valueOf(examFormatModel.getPassingPercentage()));
		totalFormat = internal2Total + internal2Total + theoryTotal;
	}

	public void GetTheTotalMarks(ExamMarksModel internal1, ExamMarksModel internal2, ExamMarksModel theory,
			ExamMarksModel practical) {
		subject1TotalMarks = Float.parseFloat(String.valueOf(internal1.getMarks().getSubject1()))
				+ Float.parseFloat(String.valueOf(internal2.getMarks().getSubject1()))
				+ Float.parseFloat(String.valueOf(theory.getMarks().getSubject1()));
		subject2TotalMarks = Float.parseFloat(String.valueOf(internal1.getMarks().getSubject2()))
				+ Float.parseFloat(String.valueOf(internal2.getMarks().getSubject2()))
				+ Float.parseFloat(String.valueOf(theory.getMarks().getSubject2()));
		subject3TotalMarks = Float.parseFloat(String.valueOf(internal1.getMarks().getSubject3()))
				+ Float.parseFloat(String.valueOf(internal2.getMarks().getSubject3()))
				+ Float.parseFloat(String.valueOf(theory.getMarks().getSubject3()));
		subject4TotalMarks = Float.parseFloat(String.valueOf(internal1.getMarks().getSubject4()))
				+ Float.parseFloat(String.valueOf(internal2.getMarks().getSubject4()))
				+ Float.parseFloat(String.valueOf(theory.getMarks().getSubject4()));
		subject5TotalMarks = Float.parseFloat(String.valueOf(internal1.getMarks().getSubject5()))
				+ Float.parseFloat(String.valueOf(internal2.getMarks().getSubject5()))
				+ Float.parseFloat(String.valueOf(theory.getMarks().getSubject5()));
		subject1PracticalMarks = Float.parseFloat(String.valueOf(practical.getMarks().getSubject1()));
		subject2PracticalMarks = Float.parseFloat(String.valueOf(practical.getMarks().getSubject2()));
		subject3PracticalMarks = Float.parseFloat(String.valueOf(practical.getMarks().getSubject3()));
		subject4PracticalMarks = Float.parseFloat(String.valueOf(practical.getMarks().getSubject4()));
		subject5PracticalMarks = Float.parseFloat(String.valueOf(practical.getMarks().getSubject5()));
	}

	public void CheckFormatMarks() {
		if (subject1TotalMarks < (totalFormat * (passingPercentage / 100))) {
			lessMarksMap.put("subject1TotalMarks", totalFormat);
		}

		if (subject2TotalMarks < (totalFormat * (passingPercentage / 100))) {
			lessMarksMap.put("subject2TotalMarks", totalFormat);
		}

		if (subject3TotalMarks < (totalFormat * (passingPercentage / 100))) {
			lessMarksMap.put("subject3TotalMarks", totalFormat);
		}

		if (subject4TotalMarks < (totalFormat * (passingPercentage / 100))) {
			lessMarksMap.put("subject4TotalMarks", totalFormat);
		}

		if (subject5TotalMarks < (totalFormat * (passingPercentage / 100))) {
			lessMarksMap.put("subject5TotalMarks", totalFormat);
		}

	}

	public List<ExamGraceMarksModel> getExamGraceMarks(int year, String semester, String month, String pattern,
			String unicode) {
		Iterable<ExamGraceMarks> itExamGraceMarks = graceMarksRepo
				.findByYearAndSemesterAndMonthAndPatternAndStudentUnicode(year, semester, month, pattern, unicode);
		Gson gson = new Gson();
		String json = gson.toJson(itExamGraceMarks);
		List<ExamGraceMarksModel> listExamGraceMarksModel = gson.fromJson(json,
				new TypeToken<List<ExamGraceMarksModel>>() {
				}.getType());
		return listExamGraceMarksModel;
	}

	public List<ExamGraceMarksModel> getAllExamGraceMarks() {
		Iterable<ExamGraceMarks> itExamGraceMarks = graceMarksRepo.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(itExamGraceMarks);
		List<ExamGraceMarksModel> listExamGraceMarksModel = gson.fromJson(json,
				new TypeToken<List<ExamGraceMarksModel>>() {
				}.getType());
		return listExamGraceMarksModel;
	}

	public void updateExamMarks(ExamMarksModel examMarksModel) {
		ExamMarks examMarks, examMarks1;
		Gson gson = new Gson();
		String json = gson.toJson(examMarksModel);
		examMarks = gson.fromJson(json, ExamMarks.class);
		examMarks1 = examMarksRepository.findByYearAndSemesterAndMonthAndTypeAndPatternAndStudentUnicode(
				examMarks.getYear(), examMarks.getSemester(), examMarks.getMonth(), examMarks.getType(),
				examMarks.getPattern(), examMarks.getStudentUnicode());
		if (examMarks1 != null) {
			examMarks.setId(examMarks1.getId());
		} else {
			throw null;
		}
		examMarksRepository.save(examMarks);
	}

}
