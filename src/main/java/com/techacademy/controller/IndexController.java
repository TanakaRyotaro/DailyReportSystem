package com.techacademy.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String getIndex(@AuthenticationPrincipal UserDitail user,Model model) {
        model.addAttribute("reportslist",service.getReportsList());
        // index.htmlに画面遷移
        return "index";
    }
    /** Employee登録画面を表示 */
    @GetMapping("/entry")
    public String getEntry(@ModelAttribute Reports reports) {
        //Employee登録画面に遷移
        return "/entry";
    }
    /** Employee登録処理 */
    @PostMapping("/entry")
    public String postEntry(Reports reports,BindingResult res,Model model,@AuthenticationPrincipal UserDitail user) {
        if(res.hasErrors()) {
            // エラーあり
            return getEntry(reports);
        }
        // Employee登録
        model.addAttribute("reportslist",service.saveReports(reports));
        // 一覧画面にリダイレクト
        return "redirect:/";
    }
}