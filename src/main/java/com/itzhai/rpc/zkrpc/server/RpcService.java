package com.itzhai.rpc.zkrpc.server;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RPC接口注解
 *
 * @author pzx (zhanxuan_peng@kingdee.com)
 * @version 1.0
 * @since 20/8/2016
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component // 标明可被 Spring 扫描
public @interface RpcService {

	Class<?> value();
}