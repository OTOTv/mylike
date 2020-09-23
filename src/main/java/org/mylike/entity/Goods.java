package org.mylike.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2020-09-22 22:09:17
 */
@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = -78861233312524794L;

    private Integer id;

    private String name;

    private String type;

    private Date creatTime;

    private Integer userId;



}