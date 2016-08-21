package com.itzhai.rpc.zkrpc;

/**
 * ZK相关常量
 *
 * @version 1.0
 * @since 20/8/2016
 */
public interface Constant {

	int ZK_SESSION_TIMEOUT = 5000;

	String ZK_REGISTRY_PATH = "/registry";
	String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";
}