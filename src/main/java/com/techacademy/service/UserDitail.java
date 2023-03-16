package com.techacademy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.techacademy.entity.Employee;

public class UserDitail implements UserDetails {
    private static final long serialVersionUID = 1L;
    //employeeオブジェクト
    private final Employee employee;
    //ユーザー権限情報
    private final Collection<? extends SimpleGrantedAuthority> authorities;

    public UserDitail(Employee employee) {
        this.employee = employee;
        this.authorities = new ArrayList<SimpleGrantedAuthority>();
    }
    public Employee getUser() {
        return employee;
    }
    @Override
    public Collection<? extends SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return employee.getAuthentication().getPassword();
    }
    @Override
    public String getUsername() {
        return employee.getAuthentication().getCode();
    }
    @Override
    public boolean isAccountNonExpired() {
        //ユーザーが期限切れでなければtrueを返す
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        //ユーザーのパスワードが期限切れでなければtrueを返す
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        //ユーザーのパスワードが期限切れでなければtrueを返す
        return true;
    }
    @Override
    public boolean isEnabled() {
        //ユーザーが有効であればtrueを返す
        return true;
    }
}