package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class HotelServiceImpl implements HotelService{
    // DAO 객체 주소 요청 
	@Autowired
	private HotelRepository hDao;

	@Override
	public List<HotelListVO> hotelListData(int start, int end) {
		// TODO Auto-generated method stub
		return hDao.hotelListData(start, end);
	}

	@Override
	public HotelEntity hotelDetailData(int content_id) {
		// TODO Auto-generated method stub
		return hDao.findByContentId(content_id);
	}

	@Override
	public int hotelTotalPage() {
		// TODO Auto-generated method stub
		int count=(int)hDao.count();
		return (int)(Math.ceil(count/12.0));
	}
	
	
}
