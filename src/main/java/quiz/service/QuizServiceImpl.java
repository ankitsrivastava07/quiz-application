package quiz.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import quiz.controller.QuestionDto;
import quiz.controller.QuizSubmit;
import quiz.controller.TestResult;
import quiz.dao.QuestionDao;
import quiz.dao.entity.OptionsEntity;
import quiz.dao.repository.OptionRepo;
import quiz.dao.repository.QuestionRepo;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

	private QuestionDao questionDao;
	private QuestionRepo questionRepository;
	private OptionRepo optionRepository;

	@Override
	public TestResult submit(List<QuizSubmit> selectedOptions) {

		Integer correctAnswer = 0;
		Integer inCorrect = 0;

		List<OptionsEntity> options = optionRepository.getAllCorrectAnswers(Boolean.TRUE);
		Long totalQuestions = questionRepository.countTotalQuestions();
		List<Long> allQid = new ArrayList<>();
		Map<Long, String> correctOptionIds = new HashMap<>();

		Map<Long, Boolean> map = new HashMap<>();
		Map<Long, Long> questionAndOptions = new HashMap<>();

		options.stream().forEach(opt -> {
			map.put(opt.getId(), true);
			allQid.add(opt.getQid().getId());
			questionAndOptions.put(opt.getQid().getId(), opt.getId());

		});

		TestResult result = new TestResult();

		for (QuizSubmit quizSubmit : selectedOptions) {

			long optionId = quizSubmit.getOptionId();
			long questionId = quizSubmit.getQuestionId();
			
			StringBuilder correctIcon = new StringBuilder();
			StringBuilder incorrectIcon = new StringBuilder();

			if (map.containsKey(optionId) && map.get(optionId) == true) {
				correctAnswer++;
				correctIcon.append(
						"&nbsp;&nbsp;<img class=img_icon src='/images/correct.png' id = questionId" + questionId + ">");

				correctOptionIds.put(optionId, correctIcon.toString());
			} else {
				inCorrect++;
				Long answerId = questionAndOptions.get(questionId);
				incorrectIcon.append("&nbsp;&nbsp;<img src='/images/incorrect.png' id = questionId"
						+ questionId + ">");
				correctIcon.append(
						"&nbsp;&nbsp;<img src='/images/correct.png' id = questionId" + questionId + ">");

				correctOptionIds.put(answerId, correctIcon.toString());
				correctOptionIds.put(optionId, incorrectIcon.toString());
			}

		}
		result.setQuestionIds(allQid);
		result.setCorrectOptionIds(correctOptionIds);
		result.setAnswered((correctAnswer));
		result.setMarks(String.valueOf(correctAnswer));
		result.setMessage("Total questions " + totalQuestions);
		result.setResult("Result " + correctAnswer + "/" + "" + totalQuestions + "(" +

				percentage(Double.valueOf(correctAnswer), Double.valueOf(totalQuestions)) + "%)");

		result.setUnAnswered((totalQuestions - (correctAnswer + inCorrect)));
		return result;
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

	@Override
	public List<QuestionDto> getAllQuestions() {
		return questionDao.getAllQuestion();
	}
}
