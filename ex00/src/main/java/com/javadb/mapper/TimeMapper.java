package com.javadb.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT sysdate FROM dual")		// sql구문을 인터페이스에 정의해 돌리는 방법
	public String getTime();
	
	public String getTime2();
}
