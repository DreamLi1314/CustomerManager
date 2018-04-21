package com.dreamli.web.model;

/**
 * @Description: 封装条件查询数据的 bean 
 * @Warning: 
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.web.model.QueryCondition.java
 * @Date: 2018年4月21日 下午3:11:12
 * @Version: 1.0.0
 */
public class QueryCondition {
	private String name;
	private String gender;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "QueryCondition [name=" + name + ", gender=" + gender + ", type=" + type + "]";
	}

}
