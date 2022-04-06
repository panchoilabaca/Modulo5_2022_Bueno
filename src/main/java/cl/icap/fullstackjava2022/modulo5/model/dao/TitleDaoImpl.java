package cl.icap.fullstackjava2022.modulo5.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.fullstackjava2022.modulo5.model.dto.TitleDto;



@Repository
@Transactional
public class TitleDaoImpl implements TitleDao {
	
	private String insert = "INSERT INTO title_types VALUES (?,?)";
	private String update = "UPDATE title_types SET title=? WHERE title_no=?";
	private String select = "SELECT * FROM title_types WHERE title_no=?";
	private String delete = "DELETE FROM title_types WHERE title_no=?";
	private String list = "SELECT * FROM title_types";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TitleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(TitleDto titleDto) {
		
		return jdbcTemplate.update(insert, new Object[]{titleDto.getTitle_no(),titleDto.getTitle()});
	}

	@SuppressWarnings("deprecation")
	@Override
	public TitleDto get(String title_no) {
		
		return  jdbcTemplate.queryForObject(select, new Object[] {title_no}, BeanPropertyRowMapper.newInstance(TitleDto.class));
	}

	@Override
	public int update(TitleDto titleDto) {
		
		return jdbcTemplate.update(update, new Object[]{titleDto.getTitle(), titleDto.getTitle_no()});
	}

	@Override
	public int delete(String title_no) {
		
			int vret = 0;
			if (jdbcTemplate.update(delete, new Object[]{title_no}) == 1) {
				vret = 1;
			}
			return vret;
		
	}

	@Override
	public List<TitleDto> list() {
		List<TitleDto> listTitle = jdbcTemplate.query(list,BeanPropertyRowMapper.newInstance(TitleDto.class));
		return listTitle;
	}

}
