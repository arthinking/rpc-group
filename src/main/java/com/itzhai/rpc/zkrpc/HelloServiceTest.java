package com.itzhai.rpc.zkrpc;

import com.itzhai.rpc.zkrpc.client.RpcProxy;
import com.itzhai.rpc.zkrpc.demo.api.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试
 *
 * @version 1.0
 * @since 20/8/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-zk-rpc-client.xml" })
public class HelloServiceTest {

	@Autowired
	private RpcProxy rpcProxy;

	@Test
	public void helloTest() {
		// 通过动态代理调用服务方法
		HelloService helloService = rpcProxy.create(HelloService.class);
		String result = helloService.hello("World");
		Assert.assertEquals("Hello! World", result);
	}
}