package com.dominos.pilot_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotLoginBasketController {

    //로그인 안 한 사용자 장바구니 처리


    /*
    사용자 로컬스토리지에 장바구니 생성
   * */
    @RequestMapping(value = "/notLogin/basket/createBasket")
    @ResponseBody
    public void createBasket(){

    }


    /*
    사용자 로컬스토리지에 장바구니 내용 업데이트
    **/
    @RequestMapping(value = "/notLogin/basket/updateBasket")
    @ResponseBody
    public void updateBasket(){

    }

    /*
    장바구니 가져오기
    **/
    @RequestMapping(value = "/notLogin/basket/getBasket")
    @ResponseBody
    public void getBasket(){

    }


    /*
    사용자 로그인 하는경우
    사용자 로컬스토리지 -> 레디스로 장바구니 이동
    **/
    @RequestMapping(value = "/notLogin/basket/moveBasket")
    @ResponseBody
    public void moveBasket(){

    }
}
