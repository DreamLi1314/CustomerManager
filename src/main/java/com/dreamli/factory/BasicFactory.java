package com.dreamli.factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @param <T>
 * @Description: 基工厂，用于创建 dao 和 service 实例 
 * @Warning: 
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.factory.BasicFactory.java
 * @Date: 2018年4月18日 上午12:44:09
 * @Version: 1.0.0
 */
public class BasicFactory {
	private static volatile BasicFactory factory;
	private static Properties properties;
	private Map<String, Object> beans = new HashMap();
	
	static {
		properties = new Properties();
		try {
			properties.load(BasicFactory.class.getResourceAsStream("beans.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Get Properties Faild...");
		}
	}
	

    private BasicFactory() {}

    public static BasicFactory getFactory() {
        if(factory == null) {
            synchronized (BasicFactory.class) {
                if(factory == null) {
                	factory = new BasicFactory();
                }
            }
        }

        return factory;
    }
    
    /**
     * @Description: 根据传入的Class名字从配置文件中读取实例名，并创建其对象返回   
     * @Warning: 
     * @Author: dreamli
     * @Date: 2018年4月18日 上午12:47:10
     * @Version: 1.0.0
     * @param clazz
     * @return dao 实例或 service 实例
     */
    public <T> T getInstance(Class<T> clazz) {
    	String key = clazz.getSimpleName();
    	
    	return null;
    }
    
	
	
}
