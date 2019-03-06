package com.OnlineResult.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class DropStudent implements Serializable {
	
	private static final long serialVersionUID = 5668763204328395145L;
	
	@Id
	@GeneratedValue
	@SequenceGenerator(initialValue=1,name="ID", sequenceName="ID")
	private Long id;
	private String studentUnicode;
	private int academicYear;

}
