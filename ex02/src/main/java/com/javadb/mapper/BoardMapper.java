package com.javadb.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import com.javadb.domain.BoardVO;

public interface BoardMapper {		// 상세내용들은 BoardMapper.xml에 기술되어 있음

	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
