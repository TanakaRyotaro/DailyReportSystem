package com.techacademy.controller;

import org.springframework.stereotype.Controller;

import java.sql.Date;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    /** 一覧画面を表示 */
    @GetMapping("/list")
    public String getList(Model model) {
        // 全件検索結果をModelに登録
        model.addAttribute("employeelist",service.getEmployeeList());
        // employee/list.htmlに画面遷移
        return "employee/list";
    }
    /** Employee登録画面を表示 */
    @GetMapping("/register")
    public String getRegister(@ModelAttribute Employee employee) {
        //Employee登録画面に遷移
        return "employee/register";
    }
    /** Employee登録処理 */
    @PostMapping("/register")
    public String postRegister(@Validated Employee employee , BindingResult res ,Model model) {
        if(res.hasErrors()) {
            // エラーあり
            return getRegister(employee);
        }
        // Employee登録
        service.saveEmployee(employee);
        // 一覧画面にリダイレクト
        return "redirect:/employee/list";
    }
    /** Employee更新画面を表示 */
    @GetMapping("/update/{id}")
    public String getEmployee(@PathVariable("id") Integer id, Model model) {
        if(id!=null) {
            //Modelに登録
            model.addAttribute("employee", service.getEmployee(id));
            //Employee更新画面に遷移
            return "employee/update";
        } else {
            model.addAttribute("employee", postEmployee(null, null, model, id));
            return "employee/update";
        }
    }
    /** Employee更新処理 */
    @PostMapping("/update/{id}")
    public String postEmployee(@Validated Employee employee, BindingResult res, Model model, @PathVariable("id") Integer id) {
        if(res.hasErrors()) {
            //エラーあり
            model.addAttribute("employee",employee);
            return "employee/update";
        }
        // Employee登録
        service.saveEmployee(employee);
        // 一覧画面にリダイレクト
        return "redirect:/employee/list";
    }
    /** Employee詳細を表示 */
    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        // Modelに登録
        model.addAttribute("employee", service.getEmployee(id));
        // Employee更新画面に遷移
        return "employee/detail";
    }
}