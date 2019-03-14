package com.OnlineResult.Model;

import java.util.List;

import lombok.Data;

@Data
public class FinalResult {
	
	private String unicode;
	private String firstName;
	private String lastName;
	private String middleName;
	private String fatherName;
	private String motherName;
	private String month;
	private boolean atkt;
	private int year;
	private String semester;
	private List<FinalMarks> listFinalMarks;
	private SujectNames subjectNames;

}
