package com.zhiliao.netty;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Zhong
 * @create2019-07-30 15:46
 */
public class Initialize {

    List<Channel> objectList = new ArrayList<>();

    public List<Channel> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Channel> objectList) {
        this.objectList = objectList;
    }

}
