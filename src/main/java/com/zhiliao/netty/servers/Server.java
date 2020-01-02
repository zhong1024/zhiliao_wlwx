package com.zhiliao.netty.servers;

import com.zhiliao.netty.TypeData;
import com.zhiliao.netty.controller.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务端
 *
 * @author Mr.Zhong
 * @create2019-08-16 9:24
 */
public class Server implements TypeData {

    //连接map
    public static Map<String, ChannelHandlerContext> map = new HashMap<String, ChannelHandlerContext>();

    /**
     * 服务端
     *
     * @param args
     */
    public void initServer(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(PORT)
                    .childHandler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            // TODO Auto-generated method stub
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new IdleStateHandler(XTARR, 0, 0));
                            pipeline.addLast(new ServerHandler());
                        }

                    });
            ChannelFuture sync = serverBootstrap.bind().sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();                                // 打印异常
        } finally {
            bossGroup.shutdownGracefully();                     // 关闭资源
            workerGroup.shutdownGracefully();
        }
    }


    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.initServer(null);
    }


}
