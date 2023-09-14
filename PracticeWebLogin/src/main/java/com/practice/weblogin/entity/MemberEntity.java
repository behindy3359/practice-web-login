package com.practice.weblogin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.practice.weblogin.dto.MemberDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String memberEmail;

	@Column
	private String memberPassword;

	@Column
	private String memberName;

	public static MemberEntity toMemberEntity(MemberDTO memberDTO) {

		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setMemberEmail(memberDTO.getMemberEmail());
		memberEntity.setMemberPassword(memberDTO.getMemberPassword());
		memberEntity.setMemberName(memberDTO.getMemberName());

		return memberEntity;
	}

	public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {

		MemberEntity memberEntity = new MemberEntity();

		memberEntity.setId(memberDTO.getId());
		memberEntity.setMemberEmail(memberDTO.getMemberEmail());
		memberEntity.setMemberPassword(memberDTO.getMemberPassword());
		memberEntity.setMemberName(memberDTO.getMemberName());

		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getMemberEmail());
		System.out.println(memberDTO.getMemberPassword());
		System.out.println(memberDTO.getMemberName());

		return memberEntity;
	}
}
