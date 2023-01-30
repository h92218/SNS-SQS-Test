package com.dominos.pilot_3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class BasketController {

    /*
    로그인 사용자
    최초 장바구니 생성
    */
    @RequestMapping(value = "/basket/insertBasket")
    @ResponseBody
    public void insertBasket(){
test11111111111111111111111111
    }


    /*
    장바구니 update
    */
    @RequestMapping(value = "/basket/updateBasket")
    @ResponseBody
    public void updateBasket(){

    }


    /*
    미로그인 사용자 장바구니 delete
    */
    @RequestMapping(value = "/basket/updateBasket")
    @ResponseBody
    public void deleteBasket(){

    }

    /*
    * 장바구니 조회
    * */
    @RequestMapping(value = "/basket/getBasket")
    @ResponseBody
    public void getBasket(){

    }
}
