package com.zhiliao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.ArrayList;
import java.util.List;

import static com.zhiliao.util.Hex22String.hexItr2Arr;


/**
 * 公用的控制器 Middleware  这就相当于一个枢纽站
 *
 * @author Mr.Zhong
 * @create2019-07-18 16:33
 */
public class Middleware extends ChannelInboundHandlerAdapter {
    /**
     * 继承ChannelInboundHandlerAdapter实现了channelRead就会监听到通道里面的消息
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
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


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

        String be = bytesToHexString(reg);
        System.out.println(be);

        String body = new String(reg, "UTF-8");
        System.out.println(body);
//        System.out.println(Thread.currentThread().getName() + "Client : " + body);

        //回复消息
        //copiedBuffer：创建一个新的缓冲区，内容为里面的参数
        //通过 ChannelHandlerContext 的 write 方法将消息异步发送给客户端

        if ("14796707710".equals(body)) {
//            byte[] c = {(byte) 0x8A, (byte) 0x01, (byte) 0x01, (byte) 0x11, (byte) 0x9B};
//            byte[] b = {(byte) 0x80, (byte) 0x01, (byte) 0x00, (byte) 0x33, (byte) 0xB2};

            ByteBuf respByteBuf = Unpooled.copiedBuffer(hexItr2Arr("8A0101119B"));
            ctx.writeAndFlush(respByteBuf);
        }
        if ("3134373936373037373130".equals(be)) {
            System.out.println("--" + true);
            Thread.sleep(2000);
        }

    }



    public static String bytesToHexString(byte[] be) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < be.length; i++) {
            String hex = Integer.toHexString(0xFF & be[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex );
        }
        return sb.toString().toUpperCase();
    }




//    protected abstract void handlerData(ChannelHandlerContext ctx,Object msg);

    //  获取数据正在打印
    protected void handlerData(ChannelHandlerContext ctx, Object msg) {
    }


    protected void sendPingMsg(ChannelHandlerContext ctx) {
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

        System.out.println(name + " 发送pong msg " + ctx.channel().remoteAddress() + " , count :" + heartbeatCount);
    }





    /**
     * READER_IDLE==读空闲
     * WRITER_IDLE==写空闲
     * ALL_IDLE==读写空闲
     *
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




    /**
     * 对设备连接上时进行数据更改
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub


        System.err.println(" 已连接：" + ctx.channel().remoteAddress() + "===");

    }

    /**
     * 对设备离线时进行数据更改
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

        System.err.println(" 已断开：" + ctx.channel().remoteAddress() + "===");
    }
}
