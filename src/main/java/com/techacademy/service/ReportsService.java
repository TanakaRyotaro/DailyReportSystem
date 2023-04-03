package com.techacademy.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techacademy.entity.Employee;
import com.techacademy.entity.Reports;
import com.techacademy.repository.ReportsRepository;

@Service
public class ReportsService {
    private final ReportsRepository reportsRepository;

    public ReportsService(ReportsRepository repository) {
        this.reportsRepository = repository;
    }
    /** 全件を検索して返す */
    public List<Reports> getReportsList() {
        // リポジトリのfindAllメソッドを呼び出す
        return reportsRepository.findAll();
    }
    /** Reportsを1件検索して返す */
    public Reports getReports(Integer id) {
        return reportsRepository.findById(id).get();
    }

    public List<Reports> findByEmployee(UserDitail user){
        return reportsRepository.findByEmployee(user.getUser());
    }
    /** Reportsの登録を行う */
    @Transactional
    public Reports saveReports(Reports reports) {
        reports.setCreatedAt(new Date(System.currentTimeMillis()));
        reports.setUpdatedAt(new Date(System.currentTimeMillis()));
        return reportsRepository.save(reports);
    }
}