package com.zhiliao.netty;
import io.netty.channel.ChannelHandlerContext;

/**
 * serverHandler控制器
 * @author Mr.Zhong
 * @create2019-07-18 16:37
 */
public class server3Handler extends Middleware {

    public server3Handler() {
        super("server");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
        // TODO Auto-generated method stub
        Model model  = (Model) msg;
        System.out.println("server 接收数据 ： " +  model.toString());
        model.setType(TypeData.CUSTOMER);
        model.setBody("====*====");
        ctx.channel().writeAndFlush(model);
        System.out.println("server 发送数据： " + model.toString());
    }

    @Override
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        // TODO Auto-generated method stub
        super.handlerReaderIdle(ctx);
        System.err.println(" 客户端 "+ ctx.channel().remoteAddress().toString() + " 读取器超时——关闭");
        ctx.close();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.err.println( name +"  异常" + cause.toString());
    }

}
