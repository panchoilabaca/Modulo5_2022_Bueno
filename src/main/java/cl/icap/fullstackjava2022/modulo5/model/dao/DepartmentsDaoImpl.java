package cl.icap.fullstackjava2022.modulo5.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.fullstackjava2022.modulo5.model.dto.DepartmentsDto;


@Repository
@Transactional
public class DepartmentsDaoImpl implements DepartmentsDao {
	
	
	
	private String insert = "INSERT INTO departments VALUES (?,?)";
	private String update = "UPDATE departments SET dept_name=? WHERE dept_no=?";
	private String select = "SELECT * FROM departments WHERE dept_no=?";
	private String delete = "DELETE FROM departments WHERE dept_no=?";
	private String list = "SELECT * FROM departments";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public DepartmentsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(DepartmentsDto departmentsDto) {
	
		return jdbcTemplate.update(insert, new Object[]{departmentsDto.getDept_no(),departmentsDto.getDept_name()});
	}

	@SuppressWarnings("deprecation")
	@Override
	public DepartmentsDto get(String dept_no) {
		return  jdbcTemplate.queryForObject(select, new Object[] {dept_no}, BeanPropertyRowMapper.newInstance(DepartmentsDto.class));
	}

	@Override
	public int update(DepartmentsDto departmentsDto) {
		
		return jdbcTemplate.update(update, new Object[]{departmentsDto.getDept_name(), departmentsDto.getDept_no()});
	}

	@Override
	public int delete(String dept_no) {
		int vret = 0;
		if (jdbcTemplate.update(delete, new Object[]{dept_no}) == 1) {
			vret = 1;
		}
		return vret;
	}

	@Override
	public List<DepartmentsDto> list() {
		List<DepartmentsDto> listDepartments = jdbcTemplate.query(list,BeanPropertyRowMapper.newInstance(DepartmentsDto.class));
		return listDepartments;
		
	}

}
