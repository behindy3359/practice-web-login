package com.practice.weblogin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.weblogin.dto.MemberDTO;
import com.practice.weblogin.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/save")
	public String memberSaveForm() {
		
		return "/member/save";
	}
	
	@PostMapping("/save")
	public String memberSave( @ModelAttribute MemberDTO memberDTO ) {
		
		memberService.save( memberDTO );
		
		return "/member/login";
	}
	
	@GetMapping("/login")
	public String memberloginForm() {
		
		return "/member/login";
	}
	
	
	
	@PostMapping("/login")
	public String memberLogin( @ModelAttribute MemberDTO memberDTO , HttpSession session) {
		
		MemberDTO loginResult = memberService.login( memberDTO );
		if( loginResult != null ) {
			//login 성공
			session.setAttribute("loginEmail", loginResult.getMemberEmail());
			System.out.println("login 성공");
			return "main";
		}else {
			//login 실패
			System.out.println("login 실패");
			return "index";
		}
	}
	
	
}
