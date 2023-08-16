package com.practice.weblogin.controller;

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
		
		return "index";
	}
}
