package com.example.demo.reposetory;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

//    @Query(value = "SELECT u.login, u.password, u.f_name, u.l_name, u.age, u.email, u.phone, u.birthday, r.role_name" +
//            " FROM User u JOIN Role r ON u.idRole=r.idRole;", nativeQuery=true)
//    List<UserRoleDto> findAllUserRoleDto();

    @Query(value = "SELECT new com.example.demo.dto.UserRoleDto(u.login, u.password, u.f_name, u.l_name, u.age, u.email, u.phone, u.birthday, r.role_name) FROM User u JOIN Role r ON u.idRole=r.idRole")
    List<UserRoleDto> findAllUserRoleDto();

    @Query(value = "SELECT new com.example.demo.dto.UserRoleDto(u.login, u.password, u.f_name, u.l_name, u.age, u.email, u.phone, u.birthday, r.role_name) FROM User u JOIN Role r ON u.idRole=r.idRole where login = :login")
    Optional<UserRoleDto> findUserRoleDtoByLogin(@Param("login") String login);
}
