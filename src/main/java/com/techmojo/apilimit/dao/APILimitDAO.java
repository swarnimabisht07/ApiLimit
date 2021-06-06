package com.techmojo.apilimit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techmojo.apilimit.beans.APILimit;

public interface APILimitDAO extends JpaRepository<APILimit, Integer> {
	
	
	public APILimit findByStudentStudentId(int studentId);

}
