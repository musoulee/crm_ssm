package com.ml.workbench.web.controller;

import com.ml.commons.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: WorkbenchIndexController
 * @author: musou
 * @Date: 2022/4/10 4:13 PM
 */
@Controller
public class WorkbenchIndexController extends BaseController {
    @RequestMapping("/workbench/index.do")
    public String index() {
        return "workbench/index";
    }
}
