package quiz.controller.question;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import quiz.controller.QuestionDto;
import quiz.service.QuizService;
import quiz.translator.ObjectTranslate;

@RestController
@RequestMapping()
@AllArgsConstructor
public class QuestionController {

	private QuizService quizService;

	private ObjectTranslate objectTranslator;

	@PostMapping("/add-question")
	public void submit(@RequestBody CreateQuestion question) {
		
		quizService.createQuestion(objectTranslator.translateToQuestionDto(question));
	}

}
