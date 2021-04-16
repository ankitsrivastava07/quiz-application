package quiz.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import quiz.controller.AnswersDto;
import quiz.controller.OptionDto;
import quiz.controller.QuestionDto;
import quiz.controller.question.CreateQuestion;
import quiz.dao.entity.AnswerEntity;
import quiz.dao.entity.OptionsEntity;
import quiz.dao.entity.QuestionEntity;

@Component
public class ObjectTranslate {

	ModelMapper mapper = new ModelMapper();

	public <D> D translate(Object source, Class<D> destinationType) {
		return mapper.map(source, destinationType);
	}

	public <S, T> List<T> translateToList(List<S> source, Class<T> destinationType) {

		return source.stream().map(obj -> mapper.map(obj, destinationType)).collect(Collectors.toList());

	}

	public QuestionDto translateToQuestionDto(CreateQuestion question) {

		QuestionDto questionDto = new QuestionDto();
		AnswersDto answer = new AnswersDto();
		List<OptionDto> list = new ArrayList<>();

		OptionDto opt1 = new OptionDto();
		opt1.setOpt(question.getOpt1());
		list.add(opt1);

		OptionDto opt2 = new OptionDto();
		opt2.setOpt(question.getOpt2());
		list.add(opt2);

		OptionDto opt3 = new OptionDto();
		opt3.setOpt(question.getOpt3());
		list.add(opt3);

		OptionDto opt4 = new OptionDto();
		opt4.setOpt(question.getOpt4());
		list.add(opt4);

		questionDto.setQuestion(question.getQuestion());

		questionDto.setOptions(list);

		answer.setAnswer(question.getAnswer());
		questionDto.setAnswer(answer);

		return questionDto;
	}

	public QuestionEntity translateToQuestionEntity(QuestionDto questionDto) {

		QuestionEntity ques = new QuestionEntity();
		AnswerEntity ans = new AnswerEntity();

		List<AnswerEntity> ansEn = new ArrayList<>();

		ques.setQuestion(questionDto.getQuestion());

		List<OptionsEntity> optionEntity = new ArrayList<>();
		questionDto.getOptions().stream().forEach(opt -> {
			OptionsEntity op = new OptionsEntity();
			op.setOpt(opt.getOpt());
			optionEntity.add(op);

		});

		ques.setOptions(optionEntity);

		ans.setAnswer(questionDto.getAnswer().getAnswer());
		ansEn.add(ans);
		ques.setAnswer(ansEn);
		return ques;

	}

}
