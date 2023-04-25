package com.ceiba.libreria.repository;

import com.ceiba.libreria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u where u.id=?1")
    Optional<User> findByUserId(Long id);

    @Query("Select u from User u")
    List<User> findAll();

    List<User> findByName(String name);

    Optional<User> findByNameAndMail(String name, String mail);

    @Query(" SELECT new com.ceiba.libreria.dto.UserDTO(u.name, u.id, u.birthDate) " +
            "from   User u " +
            "where  u.birthDate=:fecha " +
            "and    u.mail=:mail")
    Optional<User> findByMailAndDate(@Param("fecha") LocalDate fecha,
                    @Param("mail")String mail);
}
