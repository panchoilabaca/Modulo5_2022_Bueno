package cl.icap.fullstackjava2022.modulo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.fullstackjava2022.modulo5.model.dao.DepartmentsDao;
import cl.icap.fullstackjava2022.modulo5.model.dto.DepartmentsDto;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
	
	@Autowired
	DepartmentsDao departmentsDao;

	public DepartmentsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(DepartmentsDto departmentsDto) {
		
		return departmentsDao.insert(departmentsDto);
	}

	@Override
	public DepartmentsDto get(String dept_no) {
		
		return departmentsDao.get(dept_no);
	}

	@Override
	public int update(DepartmentsDto departmentsDto) {
		
		return departmentsDao.update(departmentsDto);
	}

	@Override
	public int delete(String dept_no) {
		
		return departmentsDao.delete(dept_no);
	}

	@Override
	public List<DepartmentsDto> list() {
		return departmentsDao.list();
	}

}
