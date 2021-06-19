package com.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.IAdminRepository;
import com.exception.EntityCreationException;
import com.validators.InputValidator;



@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;

	@Autowired
	InputValidator validate;

	@Override
	public void registerAdmin(String userId, String password) throws Exception {
		if (!validate.userIdValidator(userId))
			throw new EntityCreationException("Check Username !!!!");
		if (!validate.passwordValidator(password))
			throw new EntityCreationException("Cannot register this admin with this password");
		User u = new User(userId, password, "ADMIN");
		adminRepository.saveAndFlush(u);
	}

}
