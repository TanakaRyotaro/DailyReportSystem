package com.techacademy.entity;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;


import org.hibernate.annotations.Where;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;


import lombok.Data;

@Data
@Entity
@Table(name = "employee")
@Where(clause = "delete_flag = 0")

public class Employee {
    /** 主キー。自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 名前。20桁。null不許可 */
    @Column(length = 20, nullable = false)
    @NotEmpty
    @Length(max=20)
    private String name;

    /** 削除フラグ */
    @Column(name = "delete_flag", nullable = false)
    private int delete_flag;

    /** 登録日時 */
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    /** 更新日時 */
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @Valid
    private Authentication authentication;

}