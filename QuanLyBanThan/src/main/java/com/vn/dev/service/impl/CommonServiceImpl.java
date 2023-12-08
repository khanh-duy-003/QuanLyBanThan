package com.vn.dev.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.vn.dev.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Override
	public Date getDayMonthYear() {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

}
