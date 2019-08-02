package com.zhiliao.netty;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.ArrayList;
import java.util.List;


/**
 * 公用的控制器 Middleware  这就相当于一个枢纽站
 * @author Mr.Zhong
 * @create2019-07-18 16:33
 */
public class Middleware extends ChannelInboundHandlerAdapter {
    /**
     *继承ChannelInboundHandlerAdapter实现了channelRead就会监听到通道里面的消息
     */
    protected String name;
    //记录次数
    private int heartbeatCount = 0;

    //获取server and client 传入的值
    public Middleware(String name) {
        this.name = name;
    }

    static {
        List<Channel> channelList = new ArrayList<>();
    }

    /**
     * 1==
     * 2==
     * 3==
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {




//        Model m = (Model) msg;
//        int type = m.getType();
//        switch (type) {
//            case 1:
//                sendPongMsg(ctx);
//                break;
//            case 2:
//                System.out.println(name + " get  pong  msg  from" + ctx.channel().remoteAddress());
//                break;
//            case 3:
//                handlerData(ctx,msg);
//                break;
//            default:
//                break;
//        }


        /**
         * 接收到客户端发送的数据有（心跳数据包、字符指令）
         */

        //将 msg 转为 Netty 的 ByteBuf 对象，类似 JDK 中的 java.nio.ByteBuffer，不过 ButeBuf 功能更强，更灵活
        ByteBuf buf = (ByteBuf) msg;
        //readableBytes：获取缓冲区可读字节数,然后创建字节数组
        //从而避免了像 java.nio.ByteBuffer 时，只能盲目的创建特定大小的字节数组，比如 1024
        byte[] reg = new byte[buf.readableBytes()];
        //readBytes：将缓冲区字节数组复制到新建的 byte 数组中
        // 然后将字节数组转为字符串
        buf.readBytes(reg);
        String body = new String(reg, "UTF-8");
        System.out.println(Thread.currentThread().getName() + "接收到客户端发送的数据 : " + body);

        //回复消息
        //copiedBuffer：创建一个新的缓冲区，内容为里面的参数
        //通过 ChannelHandlerContext 的 write 方法将消息异步发送给客户端
        String respMsg = "I am Server，消息接收 success!";
        ByteBuf respByteBuf = Unpooled.copiedBuffer(respMsg.getBytes());
        ctx.write(respByteBuf);


    }

//    protected abstract void handlerData(ChannelHandlerContext ctx,Object msg);

    //  获取数据正在打印
    protected void handlerData(ChannelHandlerContext ctx, Object msg) { }

    protected void sendPingMsg(ChannelHandlerContext ctx){
        Model model = new Model();

        model.setType(TypeData.PING);

        ctx.channel().writeAndFlush(model);

        heartbeatCount++;

        System.out.println(name + " 发送ping消息到 " + ctx.channel().remoteAddress() + "count :" + heartbeatCount);
    }

    private void sendPongMsg(ChannelHandlerContext ctx) {

        Model model = new Model();

        model.setType(TypeData.PONG);

        ctx.channel().writeAndFlush(model);

        heartbeatCount++;

        System.out.println(name +" 发送pong msg "+ctx.channel().remoteAddress() +" , count :" + heartbeatCount);
    }


    /**
     * READER_IDLE==读空闲
     * WRITER_IDLE==写空闲
     * ALL_IDLE==读写空闲
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent stateEvent = (IdleStateEvent) evt;

        switch (stateEvent.state()) {
            case READER_IDLE:
                handlerReaderIdle(ctx);
                break;
            case WRITER_IDLE:
                handlerWriterIdle(ctx);
                break;
            case ALL_IDLE:
                handlerAllIdle(ctx);
                break;
            default:
                break;
        }
    }

    protected void handlerAllIdle(ChannelHandlerContext ctx) {
        System.err.println("读写空闲");
    }

    protected void handlerWriterIdle(ChannelHandlerContext ctx) {
        System.err.println("写空闲");
    }

    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        System.err.println("读空闲");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        GetServer.getInitialize().getObjectList().add(ctx.channel());
        System.err.println(" 已连接："+ctx.channel().remoteAddress() +"===" );

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        GetServer.getInitialize().getObjectList().remove(ctx.channel());
        System.err.println(" 已断开："+ctx.channel().remoteAddress() +"===");
    }
}
