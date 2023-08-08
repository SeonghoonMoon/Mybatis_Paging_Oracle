package com.hanatour.account.controller;

import com.hanatour.account.service.AccountV1Service;
import com.hanatour.account.vo.Criteria;
import com.hanatour.account.vo.PageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/html")
public class AccountV1Controller {

    @Autowired
    AccountV1Service v1Service;

    @GetMapping("/getList")
    public String GetList(Model model, Criteria criteria){

        log.info("-------------------------");
        log.info("list");
        log.info("-------------------------");
        System.out.println(criteria);

        /* 전체리스트 조회 - 오버로딩 */
        List<Map<String, String>> list = v1Service.getAllList(criteria);
        PageDTO  pageMaker = new PageDTO(v1Service.getAllTotal(),10,criteria);
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("list", list);
        return "/html/pageUserList";

    }

    @PostMapping("/getList")
    public String PostGetList(HttpServletRequest request, Model model, Criteria criteria){

        String strAccount = request.getParameter("account");
        String strProfile = request.getParameter("profile");

        log.info("strAccount : " + strAccount);
        log.info("strProfile : " + strProfile);

        /* 전체리스트 조회 - 오버로딩 */
        List<Map<String, String>> list = v1Service.getList(criteria, strAccount,strProfile);
        PageDTO  pageMaker = new PageDTO(v1Service.getSearchTotal(strAccount,strProfile),10,criteria);


        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("list", list);
         System.out.println("PageMaker : " + pageMaker);

        return "/html/pageUserList";

    }








    @GetMapping("/userList")
    public String getUserList(Model model){

        List<Map<String, String>> list = v1Service.getUserList();
        model.addAttribute("list", list);

        System.out.println(list);
        return "/html/userList";
    }

    @PostMapping("/userList")
    public String PostUserList(HttpServletRequest request, Model model){

        String strAccount = request.getParameter("account");
        String strProfile = request.getParameter("profile");

        log.info("strAccount : " + strAccount);
        log.info("strProfile : " + strProfile);

        /* 전체리스트 조회 - 오버로딩 */
        List<Map<String, String>> list = v1Service.getUserList(strAccount,strProfile);

        model.addAttribute("list", list);
        // System.out.println(list);

        return "/html/userList";
    }

    /* 등록하기 Get */
    @GetMapping("/createUser")
    public String createUser(){
        return "/html/createUser";
    }

    /* 등록하기 Post , HttpServletRequest 사용 */
    @PostMapping("/createUser")
    public String postCreateUser(@RequestParam(value="dept") String dept,
                               @RequestParam(value="empno") String empno,
                               @RequestParam(value="empnm") String empnm,
                               @RequestParam(value="srRequestNumber") String srRequestNumber,
                               Model model){
        log.info("dept =" + dept + "empno =" + empno + "empnm =" + empnm + "srRequestNumber =" + srRequestNumber );
        int intI = v1Service.postCreateUser(dept, empno, empnm, srRequestNumber);

        return "redirect:/html/userList";
    }

    /* 삭제하기 1 row , @RequestParam 사용  */
    @GetMapping("/dropUser")
    public String postDropUser(@RequestParam(value="username") String strUsername){

        log.info("strUsername :" + strUsername);
        int intI = v1Service.postDropUser(strUsername);

        return "redirect:/html/userList";
    }
}
