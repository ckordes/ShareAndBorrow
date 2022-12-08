package com.ckordes.ShareAndBorrow.repository;

import com.ckordes.ShareAndBorrow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByEmail(String email);
    User findByUsername(String username);
    List<User> findAllByAddressPostalCode(String postalCode);

    @Query (
            value = "select * from user join address on user.address_id = address.id  join user_tools on user.id = user_tools.user_id join tool on user_tools.tools_id = tool.id join tool_type on tool_type.id = tool.tool_type_id where address.postal_code = :postalCode and tool_type.type = :toolType",
            nativeQuery = true)
    List<User> finduserbyPostalCodeAndToolType (@Param("postalCode") String postalCode, @Param("toolType") String toolType);

    @Query (
            value = "select * from user join address on user.address_id = address.id  join user_tools on user.id = user_tools.user_id join tool on user_tools.tools_id = tool.id join tool_type on tool_type.id = tool.tool_type_id where address.postal_code = ?1 and tool_type.type = ?2",
            nativeQuery = true)
    List<User> finduserbyPostalCodeAndTool (String postalCode, String toolType);
//    @Query("select u from User u where u.address.postalCode = ?1")
//    List<User> findByAddress_PostalCode(String postalCode);
}
