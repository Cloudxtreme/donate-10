package com.djavafactory.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author fg6rrn
 *
 */
@Controller
@RequestMapping("/chart*")
public class ChartController extends BaseFormController{
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm() throws Exception{
		
		ModelAndView mv = new ModelAndView("chart");
		
		return mv;
	}

}
