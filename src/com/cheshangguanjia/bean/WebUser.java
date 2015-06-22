package com.cheshangguanjia.bean;


/**
 * WebUser entity. @author MyEclipse Persistence Tools
 */
public class WebUser implements java.io.Serializable {
	// Fields
	private Long id;
	private String username;
	private String password;
	private String name;
	private Integer roleId;
	private Short gender;
	private String headerimg;
	private String phone;
	private String email;
	private WebRole role;
	private Long pid;

	// Constructors

	/** default constructor */
	public WebUser() {
	}

	/** minimal constructor */
	public WebUser(String username, String password, String name,
			Integer roleId, Short gender) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.roleId = roleId;
		this.gender = gender;
	}

	/** full constructor */
	public WebUser(String username, String password, String name,
			Integer roleId, Short gender, String headerimg, String phone,
			String email, Long pid) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.roleId = roleId;
		this.gender = gender;
		this.headerimg = headerimg;
		this.phone = phone;
		this.email = email;
		this.pid = pid;
	}

	// Property accessors
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public String getHeaderimg() {
		return this.headerimg;
	}

	public void setHeaderimg(String headerimg) {
		this.headerimg = headerimg;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public WebRole getRole() {
		return role;
	}

	public void setRole(WebRole role) {
		this.role = role;
	}
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}