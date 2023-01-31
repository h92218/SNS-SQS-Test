package com.dominos.pilot_3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    /**
     * 단품 목록 조회
     * @return String
     */
    @RequestMapping(value = "/list")
    public String list() {
        return "list";
    }

    /**
     * 단품 상세 조회
     * @return String
     */
    @RequestMapping(value = "/detail")
    public String detail() {
        return "detail";
    }

    /**
     * H&H 상세 조회
     * @return String
     */
    @RequestMapping(value = "/hnh")
    public String hnh() {
        return "hnh";
    }

    /**
     * 인기세트 목록 조회
     * @return String
     */
    @RequestMapping(value = "/hotdealList")
    public String hotdealList() {
        return "hotdealList";
    }

    /**
     * 인기세트 상세 조회
     * @return String
     */
    @RequestMapping(value = "/hotdealDetail")
    public String hotdealDetail() {
        return "hotdealDetail";
    }

    /**
     * 마이키친
     * @return String
     */
    @RequestMapping(value = "/mykitchen")
    public String mykitchen() {
        return "mykitchen";
    }
}
