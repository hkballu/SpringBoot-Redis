package com.olive.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.olive.domain.security.Role;

//@Repository
@Component
public interface RoleRepository extends CrudRepository<Role, Long> {

}
