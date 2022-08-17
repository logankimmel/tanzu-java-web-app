package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "🌴🌴  Greetings from Spring Boot + Tanzu on TAP! 🌴🌴";
	}

} 