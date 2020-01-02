package com.zhiliao.netty.controller;

import com.zhiliao.netty.servers.Server;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import static com.zhiliao.util.Hex22String.hexItr2Arr;
import static com.zhiliao.util.Hex22String.arr2HexStr;

/**
 * 控制中心
 *
 * @author Mr.Zhong
 * @create2019-08-16 9:33
 */
public class Controller extends ChannelInboundHandlerAdapter {


//    public Controller(){
//
//    }


    /**
     * 接收到客户端发送的数据（心跳数据包、字符指令）
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        byte[] reg = new byte[buf.readableBytes()];
        buf.readBytes(reg);

        //  byte数组转化为16进制字符串
        String be = arr2HexStr(reg, false);
        System.out.println("Client message received-Hex ：" + be);
        //  获取传输过来的字符串信息
        String body = new String(reg, "UTF-8");
        System.out.println("Client message received2-Str ：" + body);


        if ("14796707710".equals(body)) {
            ByteBuf respByteBuf = Unpooled.copiedBuffer(hexItr2Arr("8A0101119B"));
            //  发送给客户端
            ctx.writeAndFlush(respByteBuf);
        }
        if ("3134373936373037373130".equals(be)) {
            System.out.println("sleep:2000");
            Thread.sleep(2000);
        }

//        ByteBuf respByteBuf = Unpooled.copiedBuffer(hexItr2Arr(""));
//        //  发送给客户端
//        ctx.writeAndFlush(respByteBuf);


    }

    /**
     * 状态控制器 （读写状态）
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

    /**
     * 读写空闲
     *
     * @param ctx
     */
    protected void handlerAllIdle(ChannelHandlerContext ctx) {
        //------
    }

    /**
     * 写空闲
     *
     * @param ctx
     */
    protected void handlerWriterIdle(ChannelHandlerContext ctx) {
        //------
    }

    /**
     * 读取器超时
     *
     * @param ctx
     */
    protected void handlerReaderIdle(ChannelHandlerContext ctx) {
        //------
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
        Server.map.put(ctx.channel().remoteAddress().toString(), ctx);   // 链接对象添加到Map中
        System.err.println(" The Connection ：" + ctx.channel().remoteAddress());

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

        System.err.println(" The Disconnect：" + ctx.channel().remoteAddress());

    }


}
