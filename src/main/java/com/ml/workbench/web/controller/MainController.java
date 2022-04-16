package com.ml.workbench.web.controller;

import com.ml.commons.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: MainController
 * @author: musou
 * @Date: 2022/4/12 8:09 PM
 */
@Controller
public class MainController extends BaseController {
    @RequestMapping("/workbench/main/index.do")
    public String index() {
        return "workbench/main/index";
    }
}
