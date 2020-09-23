package org.mylike.until;

import lombok.Data;

/**
 * Json返回数据
 * Created by Administrator on 2020/9/22.
 */
@Data
public class R {
    private Integer code;
    private String msg;
    private Object object;

    public static R success(Object object){
        return new R(object);

    }
    public static R fail(String msg){
        return new R(msg);
    }
    public R (Object object){
        this.code=200;
        this.msg="success";
        this.object=object;
    }
    public R(String msg){
        this.msg=msg;
        this.code=500;
    }
}
