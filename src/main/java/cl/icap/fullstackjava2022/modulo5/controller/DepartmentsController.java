package cl.icap.fullstackjava2022.modulo5.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cl.icap.fullstackjava2022.modulo5.model.dto.DepartmentsDto;
import cl.icap.fullstackjava2022.modulo5.service.DepartmentsService;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {
	
	@Autowired
	DepartmentsService departmentsService;
	
	@RequestMapping("/list")
	public @ResponseBody List<DepartmentsDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		
		return departmentsService.list();
		
	}
	
	@RequestMapping("/select")
	public @ResponseBody DepartmentsDto select(HttpServletRequest req, HttpServletResponse res) {
		
		return departmentsService.get(req.getParameter("dept_no"));
		
	}
	
	@RequestMapping("/delete")
	public @ResponseBody int delete(HttpServletRequest req, HttpServletResponse res) {
		
		return departmentsService.delete(req.getParameter("dept_no"));
	
}
	
	@RequestMapping("/update") 
	public @ResponseBody int update(HttpServletRequest req, HttpServletResponse res) {
		
		return departmentsService.update(new DepartmentsDto(req.getParameter("dept_no"),req.getParameter("dept_name")));
	}
	
	@RequestMapping("/insert") 
	public @ResponseBody int insert(HttpServletRequest req, HttpServletResponse res) {
		
		return departmentsService.insert(new DepartmentsDto(req.getParameter("dept_no"),req.getParameter("dept_name")));
	
}
}
