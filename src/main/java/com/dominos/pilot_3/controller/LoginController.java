package com.dominos.pilot_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    //회원 로그인
    @RequestMapping(value = "/login/member")
    @ResponseBody
    public void loginMember(){

    }

    //비회원 로그인
    @RequestMapping(value = "/login/nonMember")
    @ResponseBody
    public void loginNonMember(){

    }

    //로그아웃
    @RequestMapping(value = "/login/logout")
    @ResponseBody
    public void loginLogout(){

    }

}
