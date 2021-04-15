package quiz.controller.question;

import lombok.Data;

@Data
public class CreateQuestion {

	private String question;

	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;

	private String answer;

}
