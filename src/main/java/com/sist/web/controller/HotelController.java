package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.sist.web.entity.HotelEntity;
import com.sist.web.service.*;
import com.sist.web.vo.HotelListVO;
@Controller
public class HotelController {
   @Autowired
   private HotelService hService;
   
   @GetMapping("/") // 파일명 / redirect => 파일에 출력할 데이터 , 파일명 전송 
   public String hotel_main(@RequestParam(name="page",required = false) String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   List<HotelListVO> list=hService.hotelListData(start, end);
	   int totalpage=hService.hotelTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // 데이터를 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("main_html","main/home");
	   return "index";
   }
   
   @GetMapping("/detail")
   public String hotel_detail(@RequestParam("content_id") int content_id, Model model)
   {
	   HotelEntity vo = hService.hotelDetailData(content_id);
	   System.out.println(vo);
	   model.addAttribute("vo",vo);
	   model.addAttribute("main_html","detail");
	   return "index";
   }
   
   
}
