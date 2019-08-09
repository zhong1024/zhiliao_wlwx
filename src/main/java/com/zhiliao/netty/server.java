package com.zhiliao.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * 服务端server
 * @author Mr.Zhong
 * @create2019-07-18 16:36
 */
public class server implements TypeData {

    public void initServer(String[] args) {
        //初始化用于Acceptor的主"线程池"以及用于I/O工作的从"线程池"
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try {
            //初始化ServerBootstrap实例， 此实例是netty服务端应用开发的入口
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //通过ServerBootstrap的group方法，设置（1）中初始化的主从"线程池"
            serverBootstrap.group(bossGroup, workerGroup)
                    //指定通道channel的类型，由于是服务端，故而是NioServerSocketChannel
                    .channel(NioServerSocketChannel.class)
                    .localAddress(PORT)
                    .childHandler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            // TODO Auto-generated method stub
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new IdleStateHandler(XTARR,0,0));
//                            pipeline.addLast(new MsgPckDecode());
//                            pipeline.addLast(new MsgPckEncode());
                            pipeline.addLast(new server3Handler());
                        }

                    });
            System.out.println("服务端开启  端口： 8081 --");
            ChannelFuture sync = serverBootstrap.bind().sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //优雅的关闭资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) {

        server servers = new server();
        servers.initServer(null);

    }


}
