package com.zhiliao.netty.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 *
 * @author Mr.Zhong
 * @create2019-08-16 10:36
 */
public class MsgPckEncod extends MessageToByteEncoder<Object> {


    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf buf) throws Exception {

        //------
    }


}
