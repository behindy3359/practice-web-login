package com.practice.weblogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.weblogin.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{
	// ( select * from member_table where member_email=? )
	Optional<MemberEntity> findByMemberEmail( String memberEmail );
	
}
