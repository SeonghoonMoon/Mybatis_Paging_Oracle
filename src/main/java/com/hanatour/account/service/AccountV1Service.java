package com.hanatour.account.service;

import com.hanatour.account.dao.AccountV1Dao;
import com.hanatour.account.vo.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountV1Service {
    @Autowired
    AccountV1Dao v1Dao;


    public List<Map<String, String>> getAllList(Criteria criteria){
        List<Map<String, String>> list = v1Dao.getAllList(criteria);
        return list;
    }

    public List<Map<String, String>> getList(Criteria criteria, String strAccount,String strProfile) {

        List<Map<String, String>> list = v1Dao.getList(criteria, strAccount,strProfile);

        return list;
    }


    public int getAllTotal(){
         return v1Dao.getAllTotal();
    }

    public int getSearchTotal(String strAccount,String strProfile) {
        return v1Dao.getSearchTotal(strAccount,strProfile);
    }


     public List<Map<String, String>> getUserList() {
        List<Map<String,String>> list = v1Dao.getUserList();
        return list;
    }

    /* 전체리스트 - 오버로딩 함수 사용 */
    public List<Map<String, String>> getUserList(String strAccount,String strProfile) {
        List<Map<String, String>> list = v1Dao.getUserList(strAccount,strProfile);
        return list;
    }


    public int postCreateUser(String dept, String empno, String empnm, String srRequestNumber) {
        int intI = v1Dao.postCreateUser(dept, empno, empnm, srRequestNumber);
        return intI;
    }

    public int postDropUser(String strUsername) {
        int intI = v1Dao.postDropUser(strUsername);
        return intI;
    }


}
