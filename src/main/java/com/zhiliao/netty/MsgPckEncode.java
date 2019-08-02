package com.zhiliao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * 编码器
 * @author Mr.Zhong
 * @create2019-07-18 16:32
 */
public class MsgPckEncode extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf buf) throws Exception {
        // TODO Auto-generated method stub
        MessagePack pack = new MessagePack();

        //  使用MessagePack对数据进行序列化
        byte[] write = pack.write(msg);

        buf.writeBytes(write);

    }

}
