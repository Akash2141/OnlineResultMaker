package com.OnlineResult.Service;

import java.util.Comparator;

import com.OnlineResult.Model.ExamMarksModel;

public class YearComparator implements Comparator<ExamMarksModel>{

	@Override
	public int compare(ExamMarksModel o1, ExamMarksModel o2) {
		if(o1.getYear()==o2.getYear())
			return 0;
		else if(o1.getYear()>o2.getYear())
			return 1;
		else
			return -1;
	}

}
