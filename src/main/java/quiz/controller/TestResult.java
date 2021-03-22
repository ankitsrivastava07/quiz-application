package quiz.controller;

import java.util.Map;

import lombok.Data;

@Data
public class TestResult {

	private String message;
	private String answered;
	private String unAnswered;
	private String marks;
	private String result;
	private Map<String, String> correctOptions;
}
