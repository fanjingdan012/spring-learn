package com.bigname.demo03.service;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigname.common.StringUtil;
import com.bigname.demo03.core.Member;
import com.bigname.demo03.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper memberMapper;
	
	public Member login(String name, String passsword) throws Exception {
		System.out.println(name + passsword);
		if(StringUtil.isNullOrZero(name)){
			System.out.println("name is null");
			return null;
		}
		if(StringUtil.isNullOrZero(passsword)){
			System.out.println("password is null");
			return null;
		}
		Member member = memberMapper.selectMemberByName(name);
		return member;
	}

}
