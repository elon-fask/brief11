package com.springboot.brief11.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.brief11.entity.Employee;
@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
  Optional<Employee> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
