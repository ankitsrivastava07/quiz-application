package quiz.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import quiz.controller.QuestionDto;
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
	public TestResult submit(Map<Long, String> selectedOptions) {

		Integer correctAnswer = 0;
		Integer inCorrect = 0;
		List<AnswerEntity> list = answerRepo.findAll();

		TestResult result = new TestResult();

		Map<Long, String> answers = new HashMap<>();

		list.forEach(ans -> answers.put(ans.getQid().getId(), ans.getAnswer()));

		for (Entry<Long, String> entry : selectedOptions.entrySet()) {

			Long qid = entry.getKey();

			if (answers.containsKey(qid))

				if (entry.getValue().equals(answers.get(qid)))
					correctAnswer++;

				else
					inCorrect++;
		}

		result.setAnswered("Answered  " + (correctAnswer + inCorrect));
		result.setMarks("Marks " + correctAnswer + "/" + "" + answers.size());
		result.setMesg("Total questions " + list.size());
		result.setResult("Result " + correctAnswer + "/" + "" + answers.size() + "("
				+ percentage(Double.valueOf(correctAnswer), Double.valueOf(answers.size())) + "%)");

		result.setUnAnswered("UnAnswered " + (list.size() - (correctAnswer + inCorrect)));
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
