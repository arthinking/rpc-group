package com.itzhai.rpc.zkrpc;

/**
 * 实现服务接口
 *
 * @version 1.0
 * @since 20/8/2016
 */

@RpcService(HelloService.class) // 指定远程接口
public class HelloServiceImpl implements HelloService{

	public String hello(String name) {
		return "Hello! " + name;
	}

}
