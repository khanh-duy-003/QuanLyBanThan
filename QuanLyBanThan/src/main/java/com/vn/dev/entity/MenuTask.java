package com.vn.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vn.dev.constant.TableConstant;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
@Table(name = TableConstant.MENU_TASK)
public class MenuTask implements Serializable {
	
	@Id
	@Column(name = "MENU_ID")
	private String menuId;
	
	@Column(name = "NAME_TASK")
	private String nameTask;
	
	@Column(name = "IMAGE")
	private String image;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "DESCRIBE")
	private String describe;

}
