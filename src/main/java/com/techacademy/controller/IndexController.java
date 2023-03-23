package com.techacademy.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.techacademy.service.ReportsService;
import com.techacademy.service.UserDitail;

@Controller
public class IndexController {
    private final ReportsService service;

    public IndexController(ReportsService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getIndex(@AuthenticationPrincipal UserDitail user,Model model) {

        model.addAttribute("reportslist",service.getReportsList());
        // index.htmlに画面遷移
        return "index";
    }
}