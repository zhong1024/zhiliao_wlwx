package com.zhiliao.netty;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 客户端
 *
 * @author Mr.Zhong
 * @create2019-07-18 16:35
 */
public class Client {

    private NioEventLoopGroup worker = new NioEventLoopGroup();

    private Channel channel;

    private Bootstrap bootstrap;

    public static void main(String[] args) {
        Client client = new Client();

        client.start();

        client.sendData();
    }

    private void start() {
        bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        // TODO Auto-generated method stub
                        ChannelPipeline pipeline = ch.pipeline();
                        //  IdleStateHandler心跳机制  |--每隔5秒与服务器之间进行数据交互以确定是否正常连接
                        pipeline.addLast(new IdleStateHandler(0, 0, 5));
//                        pipeline.addLast(new MsgPckDecode());
//                        pipeline.addLast(new MsgPckEncode());
                        pipeline.addLast(new Client3Handler(Client.this));
                    }
                });
        doConnect();
    }

    /**
     * 连接服务端 and 重连
     */
    protected void doConnect() {

        if (channel != null && channel.isActive()) {
            return;
        }
        ChannelFuture connect = bootstrap.connect("127.0.0.1", 8081);
        //实现监听通道连接的方法
        connect.addListener(new ChannelFutureListener() {

            //            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {

                if (channelFuture.isSuccess()) {
                    channel = channelFuture.channel();
                    System.out.println("连接成功");
                } else {
                    System.out.println("与服务端失去连接正在重连....");
                    channelFuture.channel().eventLoop().schedule(new Runnable() {

                        //                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            doConnect();
                        }
                    }, 2, TimeUnit.SECONDS);
                }
            }
        });
    }

    /**
     * 向服务端发送消息
     */
    private void sendData() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {

            if (channel != null && channel.isActive()) {
                //  获取一个键盘扫描器
                String nextLine = sc.nextLine();
                //  NEW一个Model对象
                Model model = new Model();
                //  存入一个key值
                model.setType(TypeData.CUSTOMER);
                //  存入一个数据
                model.setBody(nextLine);
                //  writeAndFlush: 写队列并刷新
                channel.writeAndFlush(model);
            }
        }
    }

}
