package com.OnlineResult.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ExamFormat implements Serializable {

	private static final long serialVersionUID = -706393957959873981L;
	@Id
	@GeneratedValue
	@SequenceGenerator(name = "id", initialValue = 1, sequenceName = "Id")
	private Long id;
	private String semester;
	@Column(unique = true)
	private int year;
	private int internal1;
	private int internal2;
	private int external;
	private int practical;
	private int passingPercentage;

}
