package com.practice.weblogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.weblogin.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{

}
