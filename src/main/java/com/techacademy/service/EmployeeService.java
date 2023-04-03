package com.techacademy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.Authentication;
import com.techacademy.entity.Employee;
import com.techacademy.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    /** 全件を検索して返す */
    public List<Employee> getEmployeeList() {
        // リポジトリのfindAllメソッドを呼び出す
        return employeeRepository.findAll();
    }

    /** Employeeを1件検索して返す */
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }
    /** Employeeの登録を行う */
    @Transactional
    public Employee saveEmployee(Employee employee) {
        employee.setDelete_flag(0);
        employee.setCreatedAt(new Date(System.currentTimeMillis()));
        employee.setUpdatedAt(new Date(System.currentTimeMillis()));
        Authentication authentication = employee.getAuthentication();
        authentication.setPassword(passwordEncoder.encode(authentication.getPassword()));

        authentication.setEmployee(employee);
        return employeeRepository.save(employee);
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }
    /** Employeeの削除を行う */
    @Transactional
    public void delete(Integer id) {
            Employee employee = findById(id);
            employeeRepository.delete(employee);
        }
    }