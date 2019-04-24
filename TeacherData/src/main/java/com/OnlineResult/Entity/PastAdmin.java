package com.OnlineResult.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class PastAdmin implements Serializable{
	@Id
	@GeneratedValue
	@SequenceGenerator(initialValue=1,name="ID",sequenceName="ID")
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	@Column(unique=true)
	private String username;
	private String password;
}
