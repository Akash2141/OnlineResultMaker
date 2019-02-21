package com.OnlineResult.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SubjectData implements Serializable{

	private static final long serialVersionUID = -3101223996310800940L;
	
	@Id
	@GeneratedValue
	@SequenceGenerator(name="id",initialValue=1,sequenceName="Id")
	private Long id;
	private String semester;
	private int year;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private SubjectName subjectName;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private TeacherName teacherName;
	
}
