package quiz.dao;

import java.util.List;

import quiz.controller.QuestionDto;

public interface QuestionDao {

	List<QuestionDto> getAllQuestion();
}
