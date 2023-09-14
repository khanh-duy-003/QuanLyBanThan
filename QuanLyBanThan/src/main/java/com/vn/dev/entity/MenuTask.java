package com.vn.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Menutask")
public class MenuTask implements Serializable {
	
	@Id
	@Column(name = "Menu_Id")
	String menuId;
	
	@Column(name = "Name_Task")
	String nameTask;
	
	@Column(name = "Image")
	String image;
	
	@Column(name = "Url")
	String url;
	
	@Column(name = "Describe")
	String describe;

}
