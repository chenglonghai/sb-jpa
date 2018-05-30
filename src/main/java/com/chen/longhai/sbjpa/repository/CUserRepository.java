package com.chen.longhai.sbjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chen.longhai.sbjpa.entity.CUser;

public interface CUserRepository extends JpaRepository<CUser, Integer> {

	public List<CUser>findByUsername(String username);
}
