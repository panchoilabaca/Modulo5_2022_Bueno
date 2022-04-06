package cl.icap.fullstackjava2022.modulo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.fullstackjava2022.modulo5.model.dao.TitleDao;
import cl.icap.fullstackjava2022.modulo5.model.dto.TitleDto;

@Service
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	TitleDao titleDao;

	
	public TitleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(TitleDto titleDto) {
		
		return titleDao.insert(titleDto);
	}

	@Override
	public TitleDto get(String title_no) {
		
		return titleDao.get(title_no);
	}

	@Override
	public int update(TitleDto titleDto) {
		
		return titleDao.update(titleDto);
	}

	@Override
	public int delete(String title_no) {
		
		return titleDao.delete(title_no);
	}

	@Override
	public List<TitleDto> list() {
		// TODO Auto-generated method stub
		return titleDao.list();
	}

}
