package kr.ac.kopo.sun.bookmarket.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {

    @ExceptionHandler(value=RuntimeException.class)
    private ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("errorCommon");
        return modelAndView;
    }
}