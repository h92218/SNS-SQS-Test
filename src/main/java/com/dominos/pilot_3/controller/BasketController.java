package com.dominos.pilot_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BasketController {
    //로그인 사용자 장바구니 처리



    //사용자 바구니 redis에 만들기
    @RequestMapping(value = "/basket/createBasket")
    @ResponseBody
    public void createBasket(){

    }


    /*
    장바구니 내용 update
    */
    @RequestMapping(value = "/basket/updateBasket")
    @ResponseBody
    public void updateBasket(){

    }



    /*
    * 장바구니 조회
    * */
    @RequestMapping(value = "/basket/getBasket")
    @ResponseBody
    public void getBasket(){

    }


    /*
    구매 완료시에 장바구니 DB에 insert
    */
    @RequestMapping(value = "/basket/insertBasket")
    @ResponseBody
    public void insertBasket(){

    }
}
