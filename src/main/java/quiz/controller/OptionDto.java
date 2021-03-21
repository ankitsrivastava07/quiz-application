package quiz.controller;

import lombok.Data;

@Data
public class OptionDto {

	private Long id;
	private String opt;
	private QuestionDto qid;
}
