package com.vn.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.dev.entity.MenuTask;
import com.vn.dev.repository.MenuTaskRepository;
import com.vn.dev.service.MenuTaskService;

@Service
public class MenuTaskServiceImpl implements MenuTaskService{
	
	@Autowired
	MenuTaskRepository menuTaskRepo;

	@Override
	public List<MenuTask> findAll() {
		return menuTaskRepo.findAll();
	}

}
