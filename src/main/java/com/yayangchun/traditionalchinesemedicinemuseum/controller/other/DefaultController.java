package com.yayangchun.traditionalchinesemedicinemuseum.controller.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：崖洋春
 * 时间：2023/3/16 17:15
 **/
@Controller
public class DefaultController {

    @RequestMapping("/")
    public String toIndex(){
        return "redirect:/reception/toIndex";
    }
}
