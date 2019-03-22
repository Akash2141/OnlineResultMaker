package com.OnlineResult.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

import com.OnlineResult.Entity.Marks;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ExamGraceMarksModel implements Serializable{
	
	private static final long serialVersionUID = -5659796056419767147L;
	@Id
	@GeneratedValue
	@SequenceGenerator(name="Id",initialValue=1, sequenceName="ID")
	private Long id;
	private String semester;
	private String month;
	private int year;
	private String pattern;
	private String studentUnicode;
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private Marks marks;
	

}
