package com.service;

import org.springframework.http.HttpStatus;

import com.bean.User;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;

public interface IUserService {

	HttpStatus validateUser(String username, String password) throws Exception;

	public User addUser(User user) throws EntityCreationException;

	public User removeUser(User user) throws EntityDeletionException;

}