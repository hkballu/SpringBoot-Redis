package com.olive.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import com.olive.domain.User;
import com.olive.domain.security.UserRole;

//@Service
public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles);

}
