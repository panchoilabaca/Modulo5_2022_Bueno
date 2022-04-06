package cl.icap.fullstackjava2022.modulo5.service;

import java.util.List;

import cl.icap.fullstackjava2022.modulo5.model.dto.DepartmentsDto;

public interface DepartmentsService {
	
	public int insert(DepartmentsDto departmentsDto);
	public DepartmentsDto get(String dept_no);
	public int update(DepartmentsDto departmentsDTO);
	public int delete(String dept_no);
	public List<DepartmentsDto> list();



}

