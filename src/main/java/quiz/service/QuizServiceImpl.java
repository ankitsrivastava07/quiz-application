package quiz.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import quiz.controller.QuestionDto;
import quiz.controller.QuizSubmit;
import quiz.controller.TestResult;
import quiz.dao.QuestionDao;
import quiz.dao.entity.AnswerEntity;
import quiz.dao.entity.OptionsEntity;
import quiz.dao.repository.AnswerRepo;
import quiz.translator.ObjectTranslate;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

	private AnswerRepo answerRepo;
	private QuestionDao questionDao;

	@Override
	public TestResult submit(List<QuizSubmit> selectedOptions) {

		Integer correctAnswer = 0;
		Integer inCorrect = 0;
		List<AnswerEntity> answers = answerRepo.findAll();

		TestResult result = new TestResult();

		Map<String, Long> map = new HashMap<>();

		answers.stream().forEach(ans -> map.put(ans.getAnswer(),ans.getQid().getId()));

		for (QuizSubmit quizSubmit : selectedOptions) {

			if (map.containsKey(quizSubmit.getAnswer())
					&& map.get(quizSubmit.getAnswer())==quizSubmit.getQuestionId())
				correctAnswer++;
			else
				inCorrect++;

		}

		result.setAnswered("Answered  " + (correctAnswer + inCorrect));
		result.setMarks("Marks " + correctAnswer + "/" + "" + answers.size());
		result.setMessage("Total questions " + answers.size());
		result.setResult("Result " + correctAnswer + "/" + "" + answers.size() + "(" +

				percentage(Double.valueOf(correctAnswer), Double.valueOf(answers.size())) + "%)");

		result.setUnAnswered("UnAnswered " + (answers.size() - (correctAnswer + inCorrect)));
		// result.setCorrectOptions(correctAnswer);
		return result;
	}

	public List<QuestionDto> getAllQuestions() {
		List<QuestionDto> list = questionDao.getAllQuestion();
		return list;
	}

	public Double percentage(Double correctAnswer, Double totalQuestions) {
		return getTwoDecimalPlace((correctAnswer / totalQuestions) * 100);
	}

	public Double getTwoDecimalPlace(Double percentage) {

		String percent = String.valueOf(percentage);
		Double prc = Double.parseDouble(percent);
		NumberFormat nf = new DecimalFormat("##.##");
		Double result = Double.valueOf(nf.format(prc));

		return result;
	}

	public void createQuestion(QuestionDto questionDto) {

		questionDao.createQuestion(questionDto);

	}
}
