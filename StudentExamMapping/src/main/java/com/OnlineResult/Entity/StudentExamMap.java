package com.OnlineResult.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class StudentExamMap implements Serializable{

	private static final long serialVersionUID = -1614058049451722524L;

	@Id
	@GeneratedValue
	@SequenceGenerator(name="id",initialValue=1,sequenceName="Id")
	private Long id;
	private String studentUnicode;
	private int regularExamAttemptedYear;
	private String month;
	
}
