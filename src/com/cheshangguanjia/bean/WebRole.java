package com.cheshangguanjia.bean;


/**
 * WebRole entity. @author MyEclipse Persistence Tools
 */
public class WebRole implements java.io.Serializable {

	public static final String[][] appauths = { { "店总工作台", "1" },
			{ "销售经理工作台", "2" }, { "销售员工作台", "3" },
			{ "售后经理工作台", "4" }, { "客服工作台", "5" }, { "SA工作台", "6" },
			{ "故障求援工作台", "7" }, { "续保工作台", "8" } };

	protected Integer id;
	protected String name;
	protected String moreinf;
	protected Integer pid;
	protected Short appauth;
	protected Short webAllow;

	public WebRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoreinf() {
		return this.moreinf;
	}

	public void setMoreinf(String moreinf) {
		this.moreinf = moreinf;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Short getAppauth() {
		return appauth;
	}

	public void setAppauth(Short appauth) {
		this.appauth = appauth;
	}

	public Short getWebAllow() {
		return webAllow;
	}

	public void setWebAllow(Short webAllow) {
		this.webAllow = webAllow;
	}
}