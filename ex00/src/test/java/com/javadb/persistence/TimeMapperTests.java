package com.javadb.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javadb.mapper.TimeMapper;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Setter(onMethod_ =@Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());			// 시간은 오라클에서 가져옴! // sql구문을 인터페이스에 정의해 돌리는 방법
	}
	
	@Test
	public void testGetTime2() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime2());			// 시간은 오라클에서 가져옴! // sql구문을 xml파일에 정의해 돌리는 방법
	}
}
