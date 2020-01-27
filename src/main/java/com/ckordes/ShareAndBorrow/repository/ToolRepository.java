package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    Tool findById(long id);
}
