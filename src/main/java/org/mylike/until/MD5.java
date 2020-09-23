package org.mylike.until;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Objects;


/**
 * 密码MD5加密类
 * Created by Administrator on 2020/9/22.
 */
public class MD5 {
    //盐
    private static final String salt="c3h2r";

    public static String md5(String input){
        return DigestUtils.md5Hex(input);
    }

    public static String one(String str){
        String a=""+salt.charAt(1)+salt.charAt(4)+str+salt.charAt(0)+salt.charAt(2);
        return md5(a);
    }
    public static String two(String str){
        String b=""+salt.charAt(1)+salt.charAt(4)+str+salt.charAt(0)+salt.charAt(2);
        return md5(b);
    }

    /**
     * @param str 明文
     * @return MD5转码后的字符串
     * */
    public static String md5Hex(String str){
        String one=one(str);
        String two=two(one);
        return two;
    }

    public static void main(String[] args) {
        String psw="a123";
        psw=  md5Hex(psw);
        System.out.println(psw);
        System.out.println(Objects.equals(psw,md5Hex("a123")));
    }

}
