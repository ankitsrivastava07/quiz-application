package quiz.controller;

import lombok.Data;

@Data
public class TestResult {

	private String mesg;
	private String answered;
	private String unAnswered;
	private String marks;
	private String result;
}
