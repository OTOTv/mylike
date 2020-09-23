package org.mylike.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-09-22 22:05:24
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 767150561976676499L;

    private Integer id;

    private Integer userId;

    private Integer goodsId;


}