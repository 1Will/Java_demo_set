package com.fsj.spring.model.sys;
// default package


/**
 * SysMenuOper generated by MyEclipse Persistence Tools
 */

public class SysMenuOper implements java.io.Serializable {

	// Fields

	private Long id;

	/**
	 * 操作名称
	 */
	private String smoName;

	/**
	 * 操作控件id 或 name
	 */
	private String smoOperation;

	//private String smoMenuId;
	/**
	 * 关联菜单
	 */
	private SysMenu sysMenu;

	/**
	 * 是否可用
	 */
	private String smoValid;

	// Constructors

	/** default constructor */
	public SysMenuOper() {
	}

	/** minimal constructor */
	public SysMenuOper(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SysMenuOper(Long id, String smoName, String smoOperation, SysMenu sysMenu, String smoValid) {
		this.id = id;
		this.smoName = smoName;
		this.smoOperation = smoOperation;
		this.sysMenu = sysMenu;
		this.smoValid = smoValid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSmoName() {
		return this.smoName;
	}

	public void setSmoName(String smoName) {
		this.smoName = smoName;
	}

	public String getSmoOperation() {
		return this.smoOperation;
	}

	public void setSmoOperation(String smoOperation) {
		this.smoOperation = smoOperation;
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public String getSmoValid() {
		return this.smoValid;
	}

	public void setSmoValid(String smoValid) {
		this.smoValid = smoValid;
	}

}