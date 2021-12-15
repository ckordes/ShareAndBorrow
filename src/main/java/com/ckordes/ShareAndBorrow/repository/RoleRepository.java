package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
