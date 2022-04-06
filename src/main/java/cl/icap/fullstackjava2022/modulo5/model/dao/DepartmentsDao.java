package cl.icap.fullstackjava2022.modulo5.model.dao;

import java.util.List;

import cl.icap.fullstackjava2022.modulo5.model.dto.DepartmentsDto;

public interface DepartmentsDao {
	public int insert(DepartmentsDto departmentsDto);
	public DepartmentsDto get( String dept_no);
	public int update(DepartmentsDto departmentsDto);
	public int delete(String dept_no);
	public List<DepartmentsDto> list();



}

