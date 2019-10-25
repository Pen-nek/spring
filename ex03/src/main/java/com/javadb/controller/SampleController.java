package com.javadb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadb.domain.SampleVO;
import com.javadb.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	// 단순 문자열 반환
		// 기본 주소에 /sample/getText를 치면 내용 확인 가능
	
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	// 객체의 반환
	// SampleVO를 먼저 만들어 둬야 함
		// 기본 주소에 /sample/getSample 치면 내용 확인 가능
		// .json을 더하면 json형태로도 확인 가능
	
	@GetMapping(value = "/getSample",
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
						MediaType.APPLICATION_XML_VALUE })		// XML 포맷으로 돌리겠다
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	// 컬렉션 타입의 객체 반환	
		// List 클래스는 java.util에서 임포트할 것. awt는 GUI 프로그램에서 씀
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		
		return IntStream.range(1, 21).mapToObj(i -> new SampleVO(i, i + " First", i + " Last"))
				.collect(Collectors.toList());
	}
	
	// 맵 : 키와 값을 가지는 하나의 객체로 간주
		// json형태로도 확인 가능
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap() {
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "이", "혜민"));
		
		return map;
	}
	
	@GetMapping(value = "/check", params = { "height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	// @PathVariable : URL경로의 일부를 파라미터로 사용할 때 쓰는 에노테이션	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) {
		
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
	// @RequestBody : 전달된 요청 내용을 이용해서 해당 파라미터 타입으로 변환 요구
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		log.info("convert........ticket" + ticket);
		
		return ticket;
	}

}
