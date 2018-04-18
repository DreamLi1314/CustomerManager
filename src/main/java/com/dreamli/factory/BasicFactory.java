package com.dreamli.factory;

import java.io.FileReader;
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
	private static Properties beansConfig;
	/**
	 * 存放配置文件中配置的 bean， 以保证在整个应用程序中这些 bean 都只有一个实例
	 */
	private Map<String, Object> beans = new HashMap<String, Object>();
	
	static {
		try {
			beansConfig = new Properties();
			beansConfig.load(new FileReader(BasicFactory.class.getClassLoader().getResource("beans.properties").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Get Properties Faild...");
		}
	}
	

    private BasicFactory() {}

    /**
     * @Description: 获取工厂实例   
     * @Warning: 
     * @Author: dreamli
     * @Date: 2018年4月18日 下午10:15:26
     * @Version: 1.0.0
     * @return
     */
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
     * @Description: 根据传入的Class名字获取相应实例对象， 如果已经创建过就直接返回，如果没有创建过从配置文件中读取实例名，并创建其对象返回   
     * @Warning: 
     * @Author: dreamli
     * @Date: 2018年4月18日 上午12:47:10
     * @Version: 1.0.0
     * @param clazz
     * @return dao 实例或 service 实例
     */
    public <T> T getInstance(Class<T> clazz) {
    	try {
			String key = clazz.getSimpleName();
			String className = beansConfig.getProperty(key);
			T bean = null;

			if(!beans.containsKey(key)) {
				synchronized (beans) {
					if(beans.containsKey(key)) {
						bean = (T) beans.get(key);
					} else {
						bean = (T) Class.forName(className).newInstance();
						beans.put(key, bean);
					}
				}
			} else {
				bean = (T) beans.get(key);
			}

			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("get  instance of [" + clazz + "] faild...");
		}
    }
}
