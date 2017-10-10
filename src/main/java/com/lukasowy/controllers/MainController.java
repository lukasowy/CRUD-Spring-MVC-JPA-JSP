package com.lukasowy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
public class MainController {
	@RequestMapping(path="/hello") // This means URL's start with /demo (after Application path)
	public String hello() {
		return "hello";
	}
	
	
	
}
