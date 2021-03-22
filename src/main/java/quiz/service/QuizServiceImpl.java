package quiz.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import quiz.controller.QuestionDto;
import quiz.controller.QuizSubmit;
import quiz.controller.TestResult;
import quiz.dao.QuestionDao;
import quiz.dao.entity.AnswerEntity;
import quiz.dao.repository.AnswerRepo;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

	private AnswerRepo answerRepo;
	private QuestionDao questionDao;

	@Override
	public TestResult submit(List<QuizSubmit> selectedOptions) {

		Integer correctAnswer = 0;
		Integer inCorrect = 0;
		List<AnswerEntity> list = answerRepo.findAll();

		TestResult result = new TestResult();

		Map<Long, Boolean> map = new HashMap<>();

		list.forEach(ans -> map.put(ans.getOption().getId(), ans.getIsCorrect()));

		for (QuizSubmit quizSubmit : selectedOptions) {

			if (map.containsKey(quizSubmit.getOptionId()) && map.get(quizSubmit.getOptionId()) == true)
				correctAnswer++;
			else
				inCorrect++;

		}

		result.setAnswered("Answered  " + (correctAnswer + inCorrect));
		result.setMarks("Marks " + correctAnswer + "/" + "" + list.size());
		result.setMessage("Total questions " + list.size());
		result.setResult("Result " + correctAnswer + "/" + "" + list.size() + "(" +

				percentage(Double.valueOf(correctAnswer), Double.valueOf(list.size())) + "%)");

		result.setUnAnswered("UnAnswered " + (list.size() - (correctAnswer + inCorrect)));
		//result.setCorrectOptions(correctAnswer);
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
}
