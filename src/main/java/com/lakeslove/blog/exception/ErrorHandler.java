package com.lakeslove.blog.exception;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandler {
	
	private static final Logger log = LogManager.getLogger(ErrorHandler.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView resolveException(
			Exception ex,
			HttpServletRequest request,
			HttpServletResponse response) {
		ex.printStackTrace();
		log.error(ex.getMessage());
		Map<String, Object> model = new HashMap<String, Object>();
//		if(ex instanceof CustomException){
//			model.put("errorMessage", ex.getMessage());
////			log.error(ex.getMessage());
//		}else{
//			log.error(ex.getMessage(), ex);
//			model.put("errorMessage", "system error");
//		}
//		model.put("isIndexPage", true);
		return new ModelAndView("tiles.view.body.testError", model);
	}
}
