package com.techacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
    @Column(name = "code",length = 20, nullable = false)
    @Length(max=20)
    @NotEmpty
    private String code;
    /** パスワード */
    @Column(name = "password", length = 255, nullable = false)
    @Length(max=255)
    @NotEmpty
    private String password;
    /** 権限 */
    @Column(name = "role",length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    /** 従業員テーブルのID */
    @OneToOne
    @JoinColumn(name = "employee_id",referencedColumnName="id")
    private Employee employee;

}