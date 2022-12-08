package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.ToolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolTypeRepository extends JpaRepository<ToolType, Long> {
    ToolType findByType(String type);
}
