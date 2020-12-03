package com.example.spring.service.impl;

import com.example.spring.bean.User;
import com.example.spring.service.UserService;
import org.springframework.stereotype.Repository;

@Repository("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {
	
}