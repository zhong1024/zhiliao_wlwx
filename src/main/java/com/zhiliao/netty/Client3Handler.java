package com.zhiliao.netty;
import io.netty.channel.ChannelHandlerContext;

/**
 * 客户端的handler控制器
 * 继承我们自己编写的枢纽站
 * @author Mr.Zhong
 * @create2019-07-18 16:36
 */
public class Client3Handler extends Middleware {

    private Client client;

    public Client3Handler(Client client) {
        super("client");
        this.client = client;
    }

//    @Override
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
        // TODO Auto-generated method stub
        Model model = (Model) msg;
        System.out.println("client  收到数据： " + model.toString());
    }
    @Override
    protected void handlerAllIdle(ChannelHandlerContext ctx) {
        // TODO Auto-generated method stub
        super.handlerAllIdle(ctx);
        sendPingMsg(ctx);
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelInactive(ctx);
        client.doConnect();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println(name + "exception :"+ cause.toString());
    }

}
