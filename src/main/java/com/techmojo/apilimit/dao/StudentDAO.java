package com.techmojo.apilimit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmojo.apilimit.beans.Student;


@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

}
