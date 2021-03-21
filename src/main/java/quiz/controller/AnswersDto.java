package quiz.controller;

import lombok.Data;

@Data
public class AnswersDto {
	private Long qid;
	private String selectedOption;
}
