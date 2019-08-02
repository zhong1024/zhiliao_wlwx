package com.zhiliao.netty;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.Zhong
 * @create2019-07-30 15:01
 */
public class Session {

//
//    //Session的唯一标识
//    private String id;
//    //和Session相关的channel,通过它向客户端回送数据
//    private Channel channel = null;
//    //上次通信时间
//    private long lastCommunicateTimeStamp = 0l;
//    //快速构建一个新的Session
//    public static Session buildSession(Channel channel) {
//        Session session = new Session();
//        session.setChannel(channel);
//     //此处暂且使用netty生成的类似UUID的字符串,来标识一个session
//        session.setId(channel.id().asLongText());
//        session.setLastCommunicateTimeStamp(System.currentTimeMillis());
//        return session;
//    }


//    private ConcurrentHashMap<String, Channel> sessionChannelMap = new ConcurrentHashMap<String, Channel>();
//
//    //用来保存session和channel的关系，当需要给某个客户端推送消息时
//
//    Channel channel=sessionChannelMap .get(session);
//
//    channel.write(message);

//
//    channelFuture.channel().writeAndFlush();

}
