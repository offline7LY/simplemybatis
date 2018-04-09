package com.lx.mybatis.model;

   /**
    * t_person 实体类
    * Mon Apr 02 22:51:44 CST 2018 bean
    */ 


public class Person{
	private Integer id;
	private String account;
	private String password;
	private String sex;
	private String name;
	private String email;
	private String ipcreated;
	private String iplastactived;
	private Integer type;
	private String picture;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setAccount(String account){
		this.account=account;
	}
	public String getAccount(){
		return account;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setIpcreated(String ipcreated){
		this.ipcreated=ipcreated;
	}
	public String getIpcreated(){
		return ipcreated;
	}
	public void setIplastactived(String iplastactived){
		this.iplastactived=iplastactived;
	}
	public String getIplastactived(){
		return iplastactived;
	}
	public void setType(Integer type){
		this.type=type;
	}
	public Integer getType(){
		return type;
	}
	public void setPicture(String picture){
		this.picture=picture;
	}
	public String getPicture(){
		return picture;
	}
}

