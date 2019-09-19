package com.javadb.sample;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	@Setter(onMethod_=@Autowired)	// 표현방법이 버전에 따라 조금씩 다름. 자바 1.8 버전 이후는 이렇게 사용
	private Chef chef;
}
