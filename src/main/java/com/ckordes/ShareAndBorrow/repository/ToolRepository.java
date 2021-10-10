package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    Tool findById(long id);
    List<Tool> findAllByUserID(long userID);
    List<Tool> findByToolTypeId(long toolTypeID);
}
