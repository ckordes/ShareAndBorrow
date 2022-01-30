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
//    @Query(value = "select street, tool_type.type , tool.name, tool.description, user.username , user.id from ShareAndBorrow.tool join user_tools on ShareAndBorrow.tool.id = user_tools.tools_id join user on user_tools.user_id = user.id join ShareAndBorrow.address on user.username = address.user_name join tool_type on tool.tool_type_id = tool_type.id where address.postal_code = ?1 order by address.street", nativeQuery = true)
//    @Query(value = "select * from Shareandborrow.tool where tool.id = ?1",nativeQuery = true)
//            @Query(value = "select * from tool where tool.id = ?1",nativeQuery = true)
//            List<User>(Long id);
//    List<AddressToolUser>(String inZipCode);
}
