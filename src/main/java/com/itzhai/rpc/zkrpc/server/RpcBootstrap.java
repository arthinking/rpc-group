package com.itzhai.rpc.zkrpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * RPC服务启动入口
 *
 * @version 1.0
 * @since 20/8/2016
 */
public class RpcBootstrap {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring/spring-zk-rpc-server.xml");
	}
}
