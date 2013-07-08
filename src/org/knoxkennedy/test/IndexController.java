package org.knoxkennedy.test;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	@Autowired 
	UserService userService;
	//private static final Logger logger = Logger
	//		.getLogger(IndexController.class.getCanonicalName());

	@RequestMapping(value = "/")
	public ModelAndView indexPage() {
		//logger.debug("IndexController");

		// ModelAndView mav = new ModelAndView("/WEB-INF/views/index.jsp");
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("serverTime", new Date());
		return mav;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		return "welcome";
	}

}