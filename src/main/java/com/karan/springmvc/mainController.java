package com.karan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	@RequestMapping("/welcome")
	public String display() {
		return "welcome";
	}
}
