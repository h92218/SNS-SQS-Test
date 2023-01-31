package com.dominos.pilot_3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 단품 목록 조회
     * @return String
     */
    @RequestMapping(value = "/list")
    public String list() {
        logger.info("logger.info=list");
        return "list";
    }

    /**
     * 단품 상세 조회
     * @return String
     */
    @RequestMapping(value = "/detail")
    public String detail() {
        logger.info("logger.info=detail");
        return "detail";
    }

    /**
     * H&H 상세 조회
     * @return String
     */
    @RequestMapping(value = "/hnh")
    public String hnh() {
        logger.info("logger.info=hnh");
        return "hnh";
    }

    /**
     * 인기세트 목록 조회
     * @return String
     */
    @RequestMapping(value = "/hotdealList")
    public String hotdealList() {
        logger.info("logger.info=hotdealList");
        return "hotdealList";
    }

    /**
     * 인기세트 상세 조회
     * @return String
     */
    @RequestMapping(value = "/hotdealDetail")
    public String hotdealDetail() {
        logger.info("logger.info=hotdealDetail");
        return "hotdealDetail";
    }

    /**
     * 마이키친
     * @return String
     */
    @RequestMapping(value = "/mykitchen")
    public String mykitchen() {
        logger.info("logger.info=mykitchen");
        return "mykitchen";
    }
}
