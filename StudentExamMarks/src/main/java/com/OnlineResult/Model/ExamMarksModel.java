package com.OnlineResult.Model;

import lombok.Data;

@Data
public class ExamMarksModel {
	
	private Long id;
	private String semester;
	private int year;
	private String month;
	private String type;
	private boolean atkt;
	private MarksModel marks;
	
}
