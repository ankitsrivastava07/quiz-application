package quiz.controller;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class TestResult {

	private String message;
	private Integer answered;
	private Long unAnswered;
	private String marks;
	private String result;
	private List<Long> correctOptionIds;
	private List<Long> worngOptionIds;
	private List<Long> questionIds;

}
