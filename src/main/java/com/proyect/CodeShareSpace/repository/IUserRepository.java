package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

}
