package cl.icap.fullstackjava2022.modulo5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cl.icap.fullstackjava2022.modulo5.model.dto.TitleDto;
import cl.icap.fullstackjava2022.modulo5.service.TitleService;

@Controller
@RequestMapping("/title")
public class TitleController {
	
	@Autowired
	TitleService titleService;

	
	@RequestMapping("/list")
	public @ResponseBody List<TitleDto> list(){
		return titleService.list();
	
		
	}
	
	@RequestMapping("/select")
	public @ResponseBody TitleDto select(HttpServletRequest req, HttpServletResponse res) {
		
		return titleService.get(req.getParameter("title_no"));
		
	}
	
	@RequestMapping("/delete")
	public @ResponseBody int delete(HttpServletRequest req, HttpServletResponse res) {
		
		return titleService.delete(req.getParameter("title_no"));
	
}
	
	@RequestMapping("/update") 
	public @ResponseBody int update(HttpServletRequest req, HttpServletResponse res) {
		
		return titleService.update(new TitleDto(req.getParameter("title_no"),req.getParameter("title")));
	}
	
	@RequestMapping("/insert") 
	public @ResponseBody int insert(HttpServletRequest req, HttpServletResponse res) {
		
		
		
		return titleService.insert(new TitleDto(req.getParameter("title_no"),req.getParameter("title")));
	
}
}



