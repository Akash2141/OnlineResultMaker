package com.OnlineResult.Model;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentModel {
	
	private Long id;
	private String uniqueCode;
	private String firstName; 
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private String address;
	private Parent parent;
	private BatchModel batch;

}
