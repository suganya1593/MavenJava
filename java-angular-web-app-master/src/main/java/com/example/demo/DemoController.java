package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@RequestMapping(value = { "/welcome" })
	@ResponseBody
	public String redirect() {
		return "hello!";
	}

}
