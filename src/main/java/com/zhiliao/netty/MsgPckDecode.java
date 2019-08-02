package com.zhiliao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 *  解码器
 * @author Mr.Zhong
 * @create2019-07-18 16:31
 */
public class MsgPckDecode extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg,List<Object> out) throws Exception {

        final  byte[] array;

        final int length = msg.readableBytes();

        array = new byte[length];

        //
        msg.getBytes(msg.readerIndex(), array, 0, length);

        MessagePack pack = new MessagePack();

        //  pack.read(array, Model.class)  --|把接收到的byte[ ]  array 反序列化
        out.add(pack.read(array, Model.class));

    }

}
