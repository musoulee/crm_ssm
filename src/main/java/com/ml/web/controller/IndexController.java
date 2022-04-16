package com.ml.web.controller;

import com.ml.commons.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @description: IndexController
 * @author: musou
 * @Date: 2022/4/3 9:55 AM
 */
@Controller
public class IndexController extends BaseController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "musoulee");
        return "index";
    }
}
