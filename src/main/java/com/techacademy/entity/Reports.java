package com.techacademy.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

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
    private Date report_date;

    /** 日報タイトル */
    @Column(name = "title",length = 20, nullable = false)
    @Length(max=20)
    @NotEmpty
    private String title;

    /** 日報内容 */
    @Column(name = "content",length = 20, nullable = false)
    @Type(type="text")
    @Length(max=20)
    @NotEmpty
    private String content;

    /** 登録日付 */
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    /** 更新日付 */
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    /** 従業員テーブルのID */
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName="id")
    private Employee employee;
}