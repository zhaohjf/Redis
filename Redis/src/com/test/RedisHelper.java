package com.test;

import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;  

/**
 * Ҫ����Java������Redis�������в��������ȵü�����JAR����ʽ���ڵ�Java�е�Redis Client��
 * ��������ѡ��Jedis��������Java�е�Redis Client�ɼ�[1]��������ʹ��Jedis�ľ��岽�裺
 * 1)�������Maven��Ŀ�У���pom.xml������������䣺
 * [html] view plain copy
 * <dependency>  
 * 		<groupId>redis.clients</groupId>  
 * 		<artifactId>jedis</artifactId>  
 * 		<version>2.7.2</version>  
 *  	<type>jar</type>  
 * </dependency>  
 * 
 * ����Jedis JAR��
 * 
 * 2)�ڼ���Jedis JAR��֮�����ǿ���ֱ��ʹ���½�һ��Jedisʵ���ķ�����������һ����Redis�����ӣ������в�����������Mysqlһ����ÿ�β�����ʱ�򣬶��������ӣ��ܺķ����ܡ�����������Ǵ�һ�����ӳ���ȡ�����Ӷ������껹��ȥ��ʹ�����ӳصķ������ܽ���ܶ�ͬ�������⡣
 * 3)��Jedis�У�����Redis���ӵ�����JedisPool
 * 4)�����Ǿ�����������룺
 * 
 * @author Winnie
 *
 */
public class RedisHelper {  
    public static void main(String[] args) {  
        JedisPool jedisPool = new JedisPool("localhost", 6379);  
        Jedis jedis = null;  
        try {  
            jedis = jedisPool.getResource();  
            //jedis.set("rediskey1", "redisvalue1");  
           // jedis.set("rediskey2", "redisvalue2");  
            System.out.println(jedis.get("rediskey1"));  
            System.out.println(jedis.get("rediskey2"));  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (jedis != null)  
                jedis.disconnect();  
        }  
        jedisPool.destroy();  
    }  
}  