package com.test;

import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;  

/**
 * 要想在Java中连接Redis，并进行操作，首先得加载以JAR包形式存在的Java中的Redis Client，
 * 我们这里选择Jedis，其他的Java中的Redis Client可见[1]。以下是使用Jedis的具体步骤：
 * 1)如果是在Maven项目中，在pom.xml中增加如下语句：
 * [html] view plain copy
 * <dependency>  
 * 		<groupId>redis.clients</groupId>  
 * 		<artifactId>jedis</artifactId>  
 * 		<version>2.7.2</version>  
 *  	<type>jar</type>  
 * </dependency>  
 * 
 * 加载Jedis JAR包
 * 
 * 2)在加载Jedis JAR包之后，我们可以直接使用新建一个Jedis实例的方法，来建立一个到Redis的连接，并进行操作。不过跟Mysql一样，每次操作的时候，都建立连接，很耗费性能。解决方法就是从一个连接池中取出连接对象，用完还回去。使用连接池的方案还能解决很多同步性问题。
 * 3)在Jedis中，管理Redis连接的类是JedisPool
 * 4)以下是具体的样例代码：
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