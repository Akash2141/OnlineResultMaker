package com.OnlineResult.Entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Marks implements Serializable {

	private static final long serialVersionUID = -6264997347232633622L;

	private float subject1;
	private float subject2;
	private float subject3;
	private float subject4;
	private float subject5;

}
