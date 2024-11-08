package com.example.p1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class SurveyController {

	@GetMapping("/start")
	public String start() {
		return "start";
	}

	@PostMapping("/start/survey")
	public String startSurvey(HttpSession se, @RequestParam("mid") String mid) {
	    se.setAttribute("mid", mid);
	    return "redirect:/fruit";
	}

	@GetMapping("/fruit")
	public String fruit() {
		return "fruit";
	}
	
	@PostMapping("/fruit/survey")
	public String fruitSurvey(HttpSession se, @RequestParam("fruitType") String fruitType) {
		se.setAttribute("fruitType", fruitType);
		return "redirect:/hobby";
	}
	
	@GetMapping("/hobby")
	public String hobby() {
		return "hobby";
	}
	
	@PostMapping("/hobby/survey")
	public String hobbySurvey(HttpSession se, @RequestParam("hobbyType") String hobbyType) {
		se.setAttribute("hobbyType", hobbyType);
		return "redirect:/thanks";
	}

	@GetMapping("/thanks")
	public String thanks() {
		return "thanks";
	}
	
	@GetMapping("/result")
	public String result(HttpSession se, Model mo) {
		mo.addAttribute("mid", se.getAttribute("mid"));
		mo.addAttribute("fruitType", se.getAttribute("fruitType"));
		mo.addAttribute("hobbyType", se.getAttribute("hobbyType"));
		
		return "result";
	}
}
