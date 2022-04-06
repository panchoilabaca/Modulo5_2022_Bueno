package cl.icap.fullstackjava2022.modulo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebAppController {
	
	@RequestMapping("/")
	public String getHome() {
		return("index");
	}
	
	@RequestMapping("/departments_page")
	public  String getDepartments() {
		return("departments_page");
	}
	
	@RequestMapping("/titles_page")
	public String getTitle() {
		return("titles_page");
	}

}
