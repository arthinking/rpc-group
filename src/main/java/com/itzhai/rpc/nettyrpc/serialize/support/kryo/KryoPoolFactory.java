/**
 * @filename:KryoPoolFactory.java
 *
 * Newland Co. Ltd. All rights reserved.
 *
 * @Description:Kryo对象池工厂
 * @author tangjie
 * @version 1.0
 *
 */
package com.itzhai.rpc.nettyrpc.serialize.support.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;
import com.itzhai.rpc.nettyrpc.model.MessageRequest;
import com.itzhai.rpc.nettyrpc.model.MessageResponse;
import org.objenesis.strategy.StdInstantiatorStrategy;

public class KryoPoolFactory {

    private static KryoPoolFactory poolFactory = null;

    private KryoFactory factory = new KryoFactory() {
        public Kryo create() {
            Kryo kryo = new Kryo();
            kryo.setReferences(false);
            kryo.register(MessageRequest.class);
            kryo.register(MessageResponse.class);
            kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
            return kryo;
        }
    };

    private KryoPool pool = new KryoPool.Builder(factory).build();

    private KryoPoolFactory() {
    }

    public static KryoPool getKryoPoolInstance() {
        if (poolFactory == null) {
            synchronized (KryoPoolFactory.class) {
                if (poolFactory == null) {
                    poolFactory = new KryoPoolFactory();
                }
            }
        }
        return poolFactory.getPool();
    }

    public KryoPool getPool() {
        return pool;
    }
}
