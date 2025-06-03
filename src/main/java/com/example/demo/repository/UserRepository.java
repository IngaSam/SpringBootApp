package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   //первый способ запроса - native sql запрос
     @Query(value ="select * from users where email = :email", nativeQuery = true)
     Optional <User> findByEmail(String email);

  //  User findByEmail(@Param(value= "email")String email); // Если имена не совпадают

    //второй способ - jpq (JPA)
/*  @Query(value ="select u from User u where u.email = :email")
    User findByEmail(String email);*/

    //третий способ - использование JPA (ключевые слова)
    /*User findByEmailAndAgeAfterAndBirth(String email, int age, LocalDate birthday);*/

}
