package com.ceiba.libreria.repository;

import com.ceiba.libreria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<User, Long> {
}
