package com.OnlineResult.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.OnlineResult.Model.MarksModel;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ExamMarks implements Serializable{

	private static final long serialVersionUID = 2073165613525419431L;
	
	@Id
	@GeneratedValue
	@SequenceGenerator(name="Id",initialValue=1, sequenceName="ID")
	private Long id;
	private String semester;
	private int year;
	private String month;
	private String type;
	private boolean atkt;
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private MarksModel marks;
	
}
