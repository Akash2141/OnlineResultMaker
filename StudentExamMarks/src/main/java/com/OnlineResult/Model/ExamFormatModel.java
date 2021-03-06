package com.OnlineResult.Model;

import lombok.Data;

@Data
public class ExamFormatModel {
	
	private Long id;
	private String semester;
	private int year;
	private int internal1;
	private int internal2;
	private int external;
	private int practical;
	private int passingPercentage;

}
