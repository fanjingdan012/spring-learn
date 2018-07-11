package com.bigname.demo03.mapper;




import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.bigname.demo03.core.Member;

@Component
@Mapper
public interface MemberMapper {
	Member selectMemberByName(@Param("name")String name)throws Exception;
}
