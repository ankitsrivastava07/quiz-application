package quiz.service;

import java.util.List;
import java.util.Map;

import quiz.controller.QuestionDto;
import quiz.controller.TestResult;

public interface QuizService {

	TestResult submit(Map<Long, String> result);
	
	List<QuestionDto> getAllQuestions();

}

