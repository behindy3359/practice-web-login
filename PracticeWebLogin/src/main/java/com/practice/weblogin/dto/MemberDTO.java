package com.practice.weblogin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
	
	private String id;
	private String memberEmail;
	private String memberPassword;
	private String memberName;
}
