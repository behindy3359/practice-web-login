package com.practice.weblogin.service;

import org.springframework.stereotype.Service;

import com.practice.weblogin.dto.MemberDTO;
import com.practice.weblogin.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public void save(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
	}

}
