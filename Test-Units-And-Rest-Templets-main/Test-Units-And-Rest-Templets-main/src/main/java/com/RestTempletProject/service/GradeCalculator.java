package com.RestTempletProject.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class GradeCalculator {

	public String gradeCalCulator(int marks[], Integer count) {
		float percentage=0.0f;
		String grade = null;
		float totalMarks = 0.0f;

		if (marks.length>0  && count !=null ) {

			for (int mark : marks) {
				totalMarks = totalMarks + mark;

			}
			System.out.println("totalMarks"+totalMarks);
			percentage = (totalMarks / (count * 100)) * 100;
			System.out.println("hkhk"+percentage);

			if ((int) percentage/10== 9) {
				
				grade = "A";
				return grade;
			}
			if ((int) percentage / 10 == 8) {
				grade = "B";
			}
			if ((int) percentage / 10 == 7) {
				grade = "C";
			}
			
		} else {
			grade = "sorry";
		}
		return grade;

	}
}
