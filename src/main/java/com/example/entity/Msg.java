package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Msg
 * @Description 通用返回的类
 * @Version 1.0
 */
@Setter
@Getter
@ToString
public class Msg {
    //状态码   200-成功    500-失败
    private int code;
    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private Map<String, Object> info = new HashMap<String, Object>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }

    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(500);
        result.setMsg("处理失败！");
        return result;
    }

    public Msg add(String key,Object value){
        this.getInfo().put(key, value);
        return this;
    }
}
