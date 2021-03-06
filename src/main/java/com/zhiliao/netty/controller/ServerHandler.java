package com.zhiliao.netty.controller;

import io.netty.channel.ChannelHandlerContext;

/**
 * 服务端控制器
 *
 * @author Mr.Zhong
 * @create2019-08-16 9:49
 */
public class ServerHandler extends Controller {


//    public ServerHandler(){
//        super("Server");
//        // TODO Auto-generated constructor stub
//    }

    /**
     * 客户端读取超时处理
     *
     * @param ctx
     */
    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        // TODO Auto-generated method stub
        super.handlerReaderIdle(ctx);
        System.err.println(" Client： " + ctx.channel().remoteAddress().toString() + " Timeout——Close");
        ctx.close();
    }


    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("  ERROR" + cause.toString());       // 打印异常
    }


}
