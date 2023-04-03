package com.techacademy.entity;

import java.util.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Entity
@Table(name = "reports")
public class Reports  {
    /** 主キー。自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 日報日付 */
    @Column(name = "report_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportDate;

    /** 日報タイトル */
    @Column(name = "title",length = 255, nullable = false)
    @Length(max=255)
    @NotEmpty
    private String title;

    /** 日報内容 */
    @Column(name = "content",length = 255, nullable = false)
    @Type(type="text")
    @Length(max=255)
    @NotEmpty
    private String content;

    /** 登録日付 */
    @Column(name = "created_at", nullable = false,updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;

    /** 更新日付 */
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName="id")
    private Employee employee;

    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(new Date(System.currentTimeMillis()));
    }
}