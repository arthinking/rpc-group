/**
 * @filename:RpcServerJdkNativeProtocolStarter.java
 *
 * Newland Co. Ltd. All rights reserved.
 *
 * @Description:rpc服务器启动模块
 * @author tangjie
 * @version 1.0
 *
 */
package com.itzhai.rpc.nettyrpc.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RpcServerJdkNativeProtocolStarter {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("com.itzhai.rpc.nettyrpc/config/rpc-invoke-config-jdknative.xml");
    }
}

