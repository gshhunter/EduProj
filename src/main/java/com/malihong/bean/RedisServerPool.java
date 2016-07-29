package com.malihong.bean;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisServerPool {
	private static JedisPool pool = null;
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(100);
		config.setMaxWaitMillis(1000 * 100);
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, "45.63.52.164", 6379, 100*1000,"Redis@XLK910728");
	}

	public static Jedis getResource(){
		System.out.println(String.valueOf(pool.getNumActive()));

		return pool.getResource();
	}

	public static void returnResource(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
}
