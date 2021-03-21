package quiz.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {

	private QuizService quizService;

	@PostMapping("/submit")
	public ResponseEntity<?> submit(@RequestBody List<QuizSubmit> selectedOptions) {

		Map<Long, String> map = selectedOptions.stream()
				.collect(Collectors.toMap(QuizSubmit::getQuestionId, QuizSubmit::getSelectedOption));

		return new ResponseEntity<>(quizService.submit(map), HttpStatus.OK);

	}
}
