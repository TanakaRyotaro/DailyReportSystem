package com.techacademy.controller;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.techacademy.entity.Reports;
import com.techacademy.service.ReportsService;
import com.techacademy.service.UserDitail;

@Controller
public class IndexController {
    private final ReportsService service;

    public IndexController(ReportsService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String getIndex(@AuthenticationPrincipal UserDitail user,Model model,Integer id) {
        List<Reports> userlist=service.findByEmployee(user);
        model.addAttribute("reportslist",userlist);
        model.addAttribute("reportsCount",userlist.size());
        // index.htmlに画面遷移
        return "index";
    }
}