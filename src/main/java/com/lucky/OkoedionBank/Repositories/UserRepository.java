package com.lucky.OkoedionBank.Repositories;

import com.lucky.OkoedionBank.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    @Query("select u from User u where u.email = :theEmail")
    UserEntity findByEmail(@Param("theEmail") String theEmail);
}
