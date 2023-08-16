package com.practice.weblogin.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.weblogin.dto.MemberDTO;
import com.practice.weblogin.entity.MemberEntity;
import com.practice.weblogin.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public void save(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
		
		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
		
		memberRepository.save( memberEntity );
	}
	
	public MemberDTO login ( MemberDTO memberDTO ) {
		// 회원이 입력한 이메일로 DB에서 조회
		// DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
		
		
		Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail()); 
		
		if(byMemberEmail.isPresent()) {
			//조회 결과가 있다( DB에 해당 Email을 사용하는 회원이 존재 )
			MemberEntity memberEntity = byMemberEmail.get();
			if( memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword()) ) {
				//비밀번호가 일치
				//entity -> DTO 로 변환하는 과정이 필요
				MemberDTO dto = MemberDTO.toMemberDTO( memberEntity );
				return dto;
			}else {
				//비밀번호 불일치 ==> 로그인 실패
				return null;
			}
		}else{
			//조회 결과가 없다 ( DB에 해당 Email 을 사용하는 회원이 존재하지 않음 )
			return null;
		}
	}
}
