/**
 * @filename:HessianEncoder.java
 *
 * Newland Co. Ltd. All rights reserved.
 *
 * @Description:Hessian编码器
 * @author tangjie
 * @version 1.0
 *
 */
package com.itzhai.rpc.nettyrpc.serialize.support.hessian;

import com.itzhai.rpc.nettyrpc.serialize.support.MessageCodecUtil;
import com.itzhai.rpc.nettyrpc.serialize.support.MessageEncoder;

public class HessianEncoder extends MessageEncoder {

    public HessianEncoder(MessageCodecUtil util) {
        super(util);
    }
}
