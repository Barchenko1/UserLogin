package com.example.demo.reposetory;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM Role r WHERE r.role_name = :roleName", nativeQuery=true)
    Optional<Role> findByRoleName(@Param("roleName") String roleName);

}
