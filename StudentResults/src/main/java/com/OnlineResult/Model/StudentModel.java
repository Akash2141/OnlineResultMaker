package com.OnlineResult.Model;

import java.util.Date;

import lombok.Data;

@Data
public class StudentModel {
	
	private Long Id;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private Date DateOfBirth;
	private String Batch_Id;
	private String Email;
	private String Address;

}
