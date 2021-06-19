package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.User;



@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
