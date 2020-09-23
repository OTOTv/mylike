package org.mylike.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-09-22 20:39:40
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 899646064888294410L;

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String sex;



}