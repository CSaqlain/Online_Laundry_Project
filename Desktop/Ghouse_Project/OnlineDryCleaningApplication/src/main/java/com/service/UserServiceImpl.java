package com.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.IUserRepository;
import com.dao.QueryClassPersisitContext;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;
import com.exception.EntityNotFoundException;
import com.validators.InputValidator;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;
	InputValidator validate;
	@Autowired
	QueryClassPersisitContext qcp;

	@Override
	public HttpStatus validateUser(String userId, String password) throws EntityNotFoundException {
		User pUser = qcp.findByUserName(userId);
		if (pUser.getPassword().equals(password))
			return HttpStatus.ACCEPTED;
		else {
			throw new EntityNotFoundException("Invalid Password");
		}
	}

	@Override
	public User addUser(User user) throws EntityCreationException {
		if (!validate.userIdValidator(user.getUserId()))
			throw new EntityCreationException("Check Username !!!!");
		if (!validate.passwordValidator(user.getPassword()))
			throw new EntityCreationException("Cannot register this User with this password");
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User removeUser(User user) {
		try {
			User user2 = qcp.findByUserName(user.getUserId());
			userRepository.deleteById(user2.getid());
			return user2;
		} catch (Exception e) {
			throw new EntityDeletionException("Failed to Delete User");
		}
	}

}

