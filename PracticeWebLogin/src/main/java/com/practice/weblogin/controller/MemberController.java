package com.practice.weblogin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/list")
	public String memberlist( Model model ) {
		
		List< MemberDTO > memberDTOList = memberService.findAll();
		model.addAttribute( "memberList", memberDTOList);
		
		return "/member/list";
	}
	
	@GetMapping("/detail/{id}")
	public String findById(@PathVariable int id, Model model) {
		
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		
		return "/member/detail";
	}
	
	@GetMapping( "/update" )
	public String updateForm( HttpSession session, Model model ) {
		String myEmail = ( String )session.getAttribute( "loginEmail" );
		MemberDTO memberDTO = memberService.updateForm( myEmail );
		
		model.addAttribute("updateMember", memberDTO );

		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getMemberEmail());
		System.out.println(memberDTO.getMemberPassword());
		System.out.println(memberDTO.getMemberName());
		
		return "/member/update";
	}
	
	@PostMapping( "/update" )
	public String memberUpdate( @ModelAttribute MemberDTO memberDTO ){
		
		memberService.update( memberDTO );

		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getMemberEmail());
		System.out.println(memberDTO.getMemberPassword());
		System.out.println(memberDTO.getMemberName());
		
		return "redirect:/member/detail/"+ memberDTO.getId() ;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById( @PathVariable int id ) {
		
		memberService.deleteById( id );
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/logout")
	public String logout ( HttpSession session ) {
		
		session.invalidate();
		
		return "index";
	}
}
