package com.techacademy.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Reports;
import com.techacademy.service.ReportsService;
import com.techacademy.service.UserDitail;

@Controller
@RequestMapping("reports")
public class ReportsController {
    private final ReportsService service;

    public ReportsController(ReportsService service) {
        this.service = service;
    }
    /** 一覧画面を表示 */
    @GetMapping("/list")
    public String getList(Model model) {
         // 全件検索結果をModelに登録
            model.addAttribute("reportslist",service.getReportsList());
         // reports/list.htmlに画面遷移
            return "reports/list";
    }
    /** Reports登録画面を表示 */
    @GetMapping("/entry")
    public String getEntry(@ModelAttribute Reports reports,@AuthenticationPrincipal UserDitail user) {
        //reports登録画面に遷移
        reports.setEmployee(user.getUser());
        return "reports/entry";
    }
    /** Reports登録処理 */
    @PostMapping("/entry")
    public String postEntry(@Validated Reports reports,BindingResult res, Model model,@AuthenticationPrincipal UserDitail user) {
        if(res.hasErrors()) {
            // エラーあり
            return getEntry(reports,user);
        }
        reports.setEmployee(user.getUser());
        // reports登録
        model.addAttribute("reports",service.saveReports(reports));
        // 一覧画面にリダイレクト
        return "redirect:/reports/list";
    }
    /** Reports更新画面を表示 */
    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable("id") Integer id, Model model,@AuthenticationPrincipal UserDitail user,@ModelAttribute Reports reports) {
        if(id!=null) {
            //Modelに登録
            reports.setEmployee(user.getUser());
            model.addAttribute("reports", service.getReports(id));
            //reports更新画面に遷移
            return "reports/update";
        } else {
            reports.setEmployee(user.getUser());
            model.addAttribute("reports", postUpdate(null, null, model, id ,null));
            return "reports/update";
        }
    }
    /** Reports更新処理 */
    @PostMapping("/update/{id}")
    public String postUpdate(@Validated Reports reports, BindingResult res, Model model, @PathVariable("id") Integer id,@AuthenticationPrincipal UserDitail user) {
        if(res.hasErrors()) {
            //エラーあり
            reports.setEmployee(user.getUser());
            model.addAttribute("reports",reports);
            return "reports/update";
        }
        // reports登録
        reports.setEmployee(user.getUser());
        service.saveReports(reports);
        // 一覧画面にリダイレクト
        return "redirect:/reports/list";
    }
    /** Reports詳細を表示 */
    @GetMapping("/detail/{id}")
    public String getDetail(@ModelAttribute Reports reports, @PathVariable("id") Integer id, Model model) {

        model.addAttribute("reports",service.getReports(id));
        // reports詳細画面に遷移
        return "reports/detail";
    }
}