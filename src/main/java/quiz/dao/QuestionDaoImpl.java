package quiz.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import quiz.controller.QuestionDto;
import quiz.dao.entity.AnswerEntity;
import quiz.dao.entity.OptionsEntity;
import quiz.dao.entity.QuestionEntity;
import quiz.dao.repository.AnswerRepo;
import quiz.dao.repository.OptionRepo;
import quiz.dao.repository.QuestionRepo;
import quiz.translator.ObjectTranslate;

@Repository
@AllArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

	private QuestionRepo questionRepo;
	private ObjectTranslate object;
	private AnswerRepo answerRepo;

	@Override
	public List<QuestionDto> getAllQuestion() {

		List<QuestionDto> list = object.translateToList(questionRepo.findAllQuestions(), QuestionDto.class);

		return list;
	}

	@Override
	public void createQuestion(QuestionDto questionDto) {
		QuestionEntity entity = object.translateToQuestionEntity(questionDto);

		entity = questionRepo.save(entity);

	}
}
