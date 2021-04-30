package quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletRequest request, Exception ex) throws Exception {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return new ModelAndView("error/error-404");
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return new ModelAndView("error/error-500");
			}
		}
		return new ModelAndView("error/error");
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}