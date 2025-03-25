package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
