package com.diamorph.rest.webservices.restfulwebservices.jpa;

import com.diamorph.rest.webservices.restfulwebservices.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
