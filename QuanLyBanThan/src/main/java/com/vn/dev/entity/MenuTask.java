package com.vn.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity
@Table(name = "MENU_TASK")
public class MenuTask implements Serializable{
	
	@Id
	@Column(name = "MENU_ID")
	String menuId;
	
	@Column(name = "NAME_TASK")
	String nameTask;
	
	@Column(name = "IMAGE")
	String image;
	
	@Column(name = "URL")
	String url;
	
	@Column(name = "DESCRIBE")
	String describe;

}
