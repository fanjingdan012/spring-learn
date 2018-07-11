package com.bigname.demo03.service;

import org.springframework.stereotype.Service;

import com.bigname.demo03.core.Member;

@Service
public interface MemberService {
	Member login(String name, String passsword) throws Exception;
}
