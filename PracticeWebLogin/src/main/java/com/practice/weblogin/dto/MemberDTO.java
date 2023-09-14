package com.practice.weblogin.dto;

import com.practice.weblogin.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {

	private int id;
	private String memberEmail;
	private String memberPassword;
	private String memberName;

	public static MemberDTO toMemberDTO(MemberEntity memberEntity) {

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(memberEntity.getId());
		memberDTO.setMemberEmail(memberEntity.getMemberEmail());
		memberDTO.setMemberPassword(memberEntity.getMemberPassword());
		memberDTO.setMemberName(memberEntity.getMemberName());

		return memberDTO;
	}
}
