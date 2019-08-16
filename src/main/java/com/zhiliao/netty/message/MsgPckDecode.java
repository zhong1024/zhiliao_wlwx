package com.zhiliao.netty.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 解码器
 *
 * @author Mr.Zhong
 * @create2019-08-16 10:38
 */
public class MsgPckDecode extends MessageToMessageDecoder<ByteBuf> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        //------
    }


}
