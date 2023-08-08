package com.hanatour.account.dao;


import com.hanatour.account.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountV1Dao {
    /* 전체 리스트 */
    List<Map<String, String>> getUserList();

    List<Map<String, String>> getUserList(@Param("strAccount") String username, @Param("strProfile") String profile);

    int postCreateUser(@Param("dept")String dept, @Param("empno")String empno, @Param("empnm")String empnm, @Param("srRequestNumber")String srRequestNumber);

    int postDropUser(@Param("strUsername") String username);

    /* 전체 리스트 */
    List<Map<String, String>> getAllList(Criteria criteria);

    List<Map<String, String>> getList(Criteria criteria, @Param("strAccount") String username, @Param("strProfile") String profile);

    int getAllTotal();

    int getSearchTotal(@Param("strAccount") String username, @Param("strProfile") String profile);
}
