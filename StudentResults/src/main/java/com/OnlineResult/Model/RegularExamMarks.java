package com.OnlineResult.Model;

import lombok.Data;

@Data
public class RegularExamMarks {
	
	private Long id;
	private String examId;
	private String studentId;
	private float Subject1Internal1Marks;
	private float Subject2Internal1Marks;
	private float Subject3Internal1Marks;
	private float Subject4Internal1Marks;
	private float Subject5Internal1Marks;
	private float Subject1Internal2Marks;
	private float Subject2Internal2Marks;
	private float Subject3Internal2Marks;
	private float Subject4Internal2Marks;
	private float Subject5Internal2Marks;
	private float Subject1ExternalMarks;
	private float Subject2ExternalMarks;
	private float Subject3ExternalMarks;
	private float Subject4ExternalMarks;
	private float Subject5ExternalMarks;
	private float Subject1PractcalMarks;
	private float Subject2PractcalMarks;
	private float Subject3PractcalMarks;
	private float Subject4PractcalMarks;
	private float Subject5PractcalMarks;

}
