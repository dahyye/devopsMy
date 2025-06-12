package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.dao.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;
// repository => 호출 
public interface HotelService {
	public List<HotelListVO> hotelListData(int start,int end);
	public HotelEntity hotelDetailData(int content_id);	
	public int hotelTotalPage();
	
}
