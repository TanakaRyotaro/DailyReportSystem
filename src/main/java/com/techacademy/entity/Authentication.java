package com.techacademy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {

    /** 性別用の列挙型 */
    public static enum Role {
        一般, 管理者
    }
    /** 主キー。自動生成 */
    /** 社員番号 */
    @Id
    @Column(length = 20)
    private String code;
    /** パスワード */
    @Column(length = 255)
    private String password;
    /** 権限 */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;
    /** 従業員テーブルのID */
    private Integer employee_id;

}