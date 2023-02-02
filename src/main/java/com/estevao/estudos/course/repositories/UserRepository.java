package com.estevao.estudos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estevao.estudos.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
