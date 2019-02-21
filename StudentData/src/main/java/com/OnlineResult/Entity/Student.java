package com.OnlineResult.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Student implements Serializable {

	private static final long serialVersionUID = 3715630106971779528L;

	@Id
	@GeneratedValue
	@SequenceGenerator(name="id",initialValue=1,sequenceName="Id")
	private Long id;
	private String uniqueCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String batch_Id;
	private String email;
	private String address;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private Parent parent;

}
