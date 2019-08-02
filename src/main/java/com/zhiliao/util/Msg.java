package com.zhiliao.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-07-30 8:53
 */

public class Msg {

    //返回的状态
    private int status;

    //返回的提示信息
    private String inof;

    //返回的数据
    private Map<String, Object> map = new HashMap<String, Object>();

    //处理结果
    public static Msg success(){
        Msg msg = new Msg();
        msg.setStatus(100);
        msg.setInof("处理成功");
        return msg;
    }

    //处理结果
    public static Msg fail(){
        Msg msg = new Msg();
        msg.setStatus(200);
        msg.setInof("处理失败");
        return msg;
    }

    //需要返回的数据
    public Msg add(String key,Object value){
        this.getMap().put(key, value);
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int state) {
        this.status = state;
    }

    public String getInof() {
        return inof;
    }

    public void setInof(String inof) {
        this.inof = inof;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }


}
