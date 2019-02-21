package com.OnlineResult.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDataModel {

	private Long id;
	private String semester;
	private int year;
	private SubjectNameModel subjectName;
	private TeacherNameModel teacherName;
	
}
