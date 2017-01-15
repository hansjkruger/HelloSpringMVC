package coza.healthbridge.training.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hans.kruger on 2017/01/14.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

}
