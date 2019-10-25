package com.javadb.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javadb.domain.BoardVO;
import com.javadb.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//Java Config
//@ContextConfiguration(classes = {com.javadb.config.RootConfig.class})
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
//	
//	@Test
//	public void testInsert() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//	}
//	
//	@Test
//	public void testInsertSelectKey() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 select key");
//		board.setContent("새로 작성하는 내용 select key");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//	}
//	
//	@Test
//	public void testRead() {
//		
//		// 존재하는 게시물 번호로 테스트
//		BoardVO board = mapper.read(1L);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
//		
//		log.info("DELETE COUNT: " + mapper.delete(9L));
//	}
	
//	@Test
//	public void testUpdate() {
//		
//		BoardVO board = new BoardVO();
//		// 실행 전 존재하는 글번호인지 확인할 것
//		board.setBno(10L);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 내용");
//		board.setWriter("user00");
//		
//		int count = mapper.update(board);
//		log.info("UPDATE COUNT: " + count);
//	}
	
//	@Test
//	public void testPaging() {
//		
//		Criteria cri = new Criteria();
//		// 10개씩 3페이지
//		cri.setPageNum(1);
//		cri.setAmount(20);
//		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		
//		list.forEach(board -> log.info(board));
//	}
//	
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("검색");
		cri.setType("TCW");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}

}