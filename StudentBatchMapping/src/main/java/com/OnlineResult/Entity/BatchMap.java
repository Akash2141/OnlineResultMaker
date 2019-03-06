package com.OnlineResult.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.OnlineResult.Model.BatchId;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class BatchMap implements Serializable{
	
	private static final long serialVersionUID = 5781821537012586753L;
	
	@Id
	@GeneratedValue
	@SequenceGenerator(initialValue=1,name="ID",sequenceName="ID")
	private Long id;
	private String studentUnicode;
	
	@Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
	private BatchId batchId;

}
