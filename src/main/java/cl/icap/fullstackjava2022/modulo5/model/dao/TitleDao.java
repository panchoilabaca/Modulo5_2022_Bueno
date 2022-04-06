package cl.icap.fullstackjava2022.modulo5.model.dao;

import java.util.List;

import cl.icap.fullstackjava2022.modulo5.model.dto.TitleDto;

public interface TitleDao {
	
	
		public int insert(TitleDto titleDto);
		public TitleDto get(String title_no);
		public int update(TitleDto titleDto);
		public int delete(String title_no);
		public List<TitleDto> list();

}
