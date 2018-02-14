package com.protti.webapi.ws.repository;


import com.protti.webapi.ws.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

    @Query(value = "Select u from Users u where u.username=:username")
    public Users searchUser(@Param("username") String username);



}
