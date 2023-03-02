package com.techacademy.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techacademy.entity.Authentication;
import com.techacademy.service.AuthenticationService;

@Controller
@RequestMapping("authentication")
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    /** 一覧画面を表示 */
//    @GetMapping("/list")
//    public String getList(Model model) {
//        // 全件検索結果をModelに登録
//        model.addAttribute("authenticationlist",service.getAuthenticationList());
//        // employee/list.htmlに画面遷移
//        return "employee/list";
//    }
//    /** Authentication登録画面を表示 */
//    @GetMapping("/register")
//    public String getRegister(@ModelAttribute Authentication authentication) {
//        //employee登録画面に遷移
//        return "employee/register";
//    }
//    /** Authentication登録処理 */
//    @PostMapping("/register")
//    public String postRegister(@Validated Authentication authentication, BindingResult res, Model model) {
//        if(res.hasErrors()) {
//            // エラーあり
//            return getRegister(authentication);
//        }
//        // Authentication登録
//        service.saveAuthentication(authentication);
//        // 一覧画面にリダイレクト
//        return "redirect:/employee/list";
//    }
//    /** Authentication更新画面を表示 */
//    @GetMapping("/update/{id}/")
//    public String getAuthentication(@PathVariable("id") Integer id, Model model) {
//        Authentication auh=service.getAuthentication(id);
//        // Modelに登録
//        model.addAttribute("authentication", auh);
//        // employee更新画面に遷移
//        return "employee/update";
//    }
//    /** employee更新処理 */
//    @PostMapping("/update/{id}/")
//    public String postAuthentication(@Validated Authentication authentication, BindingResult res, Model model) {
//        if(res.hasErrors()) {
//            //エラーあり
//            return "employee/update";
//        }
//        // authentication登録
//        service.saveAuthentication(authentication);
//        // 一覧画面にリダイレクト
//        return "redirect:/employee/list";
//    }/** Authentication削除処理 */
//    @PostMapping(path="list", params="deleteRun")
//    public String deleteRun(@RequestParam(name="idck") Set<Integer> idck, Model model) {
//        // Authenticationを一括削除
//        service.deleteAuthentication(idck);
//        // 一覧画面にリダイレクト
//        return "redirect:/employee/list";
//    }
}