package br.com.tiagorufino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class IndexController {

	@RequestMapping("*")
	public String index(){
		
		return "login";
		
	}
	
}