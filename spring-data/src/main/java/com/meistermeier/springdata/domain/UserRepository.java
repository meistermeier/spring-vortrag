package com.meistermeier.springdata.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

    List<User> findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("select u from User u where u.name = :gender")
    User findByGender(@Param("gender") String gender);

}
