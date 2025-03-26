package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
