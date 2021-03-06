package quiz.controller.viewcontroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import quiz.service.QuizService;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class ViewController {

	private QuizService quizService;

	@GetMapping("/")
	public ModelAndView view() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("quiz");
		mv.addObject("questions", quizService.getAllQuestions());

		return mv;
	}

	@GetMapping("/add-question")
	public ModelAndView addQuestionView() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("add-question");

		return mv;
	}
}