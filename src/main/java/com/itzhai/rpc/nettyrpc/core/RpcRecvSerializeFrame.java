/**
 * @filename:RpcRecvSerializeFrame.java
 *
 * Newland Co. Ltd. All rights reserved.
 *
 * @Description:RPC服务端消息序列化协议框架
 * @author tangjie
 * @version 1.0
 *
 */
package com.itzhai.rpc.nettyrpc.core;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import java.util.Map;
import com.itzhai.rpc.nettyrpc.serialize.support.MessageCodecUtil;
import com.itzhai.rpc.nettyrpc.serialize.support.RpcSerializeFrame;
import com.itzhai.rpc.nettyrpc.serialize.support.RpcSerializeProtocol;
import com.itzhai.rpc.nettyrpc.serialize.support.hessian.HessianCodecUtil;
import com.itzhai.rpc.nettyrpc.serialize.support.hessian.HessianDecoder;
import com.itzhai.rpc.nettyrpc.serialize.support.hessian.HessianEncoder;
import com.itzhai.rpc.nettyrpc.serialize.support.kryo.KryoCodecUtil;
import com.itzhai.rpc.nettyrpc.serialize.support.kryo.KryoDecoder;
import com.itzhai.rpc.nettyrpc.serialize.support.kryo.KryoEncoder;
import com.itzhai.rpc.nettyrpc.serialize.support.kryo.KryoPoolFactory;

public class RpcRecvSerializeFrame implements RpcSerializeFrame {

    private Map<String, Object> handlerMap = null;

    public RpcRecvSerializeFrame(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline) {
        switch (protocol) {
            case JDKSERIALIZE: {
                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, MessageCodecUtil.MESSAGE_LENGTH, 0, MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new LengthFieldPrepender(MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new ObjectEncoder());
                pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                pipeline.addLast(new MessageRecvHandler(handlerMap));
                break;
            }
            case KRYOSERIALIZE: {
                KryoCodecUtil util = new KryoCodecUtil(KryoPoolFactory.getKryoPoolInstance());
                pipeline.addLast(new KryoEncoder(util));
                pipeline.addLast(new KryoDecoder(util));
                pipeline.addLast(new MessageRecvHandler(handlerMap));
                break;
            }
            case HESSIANSERIALIZE: {
                HessianCodecUtil util = new HessianCodecUtil();
                pipeline.addLast(new HessianEncoder(util));
                pipeline.addLast(new HessianDecoder(util));
                pipeline.addLast(new MessageRecvHandler(handlerMap));
                break;
            }
        }
    }
}

