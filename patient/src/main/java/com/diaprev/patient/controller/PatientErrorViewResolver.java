package com.diaprev.patient.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PatientErrorViewResolver implements ErrorViewResolver{

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
	        ModelAndView mav = new ModelAndView();
	        String errorMessage= "You are not authorized for the requested data.";
	        mav.addObject("errorMsg", errorMessage);
	        mav.setViewName("403");
	        return mav;
	}

}
