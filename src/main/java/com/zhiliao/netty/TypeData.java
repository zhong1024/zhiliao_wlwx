package com.zhiliao.netty;

/**
 *配置类接口,用于控制心跳包和应用消息的处理
 * 接口声明的变量都是static final修饰的
 * @author Mr.Zhong
 * @create2019-07-18 16:31
 */
public interface TypeData {

    byte PING = 1;

    byte PONG = 2;
    //顾客
    byte CUSTOMER = 3;

    //  超过时间未接收到客户端信息（秒）
    byte XTARR = 30;

}
