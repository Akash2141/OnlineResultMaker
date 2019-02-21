package com.OnlineResult.Model;

import lombok.Data;

@Data
public class StudentExamMapModel {
	private Long id;
	private String studentUnicode;
	private int regularExamAttemptedYear;
	private String month;
}
