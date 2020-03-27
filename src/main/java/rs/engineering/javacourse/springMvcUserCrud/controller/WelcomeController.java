package rs.engineering.javacourse.springMvcUserCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	public class WelcomeController {

	  @RequestMapping("/")
	  public String redirectPage() {
	    return "redirect:Welcome";
	  }


	  @RequestMapping("/Welcome")
	  public String showHomePage() {
	    return "index";
	  }
	}

