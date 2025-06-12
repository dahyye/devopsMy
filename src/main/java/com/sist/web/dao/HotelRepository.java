package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.HotelEntity;
import com.sist.web.vo.*;
import java.util.*;
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{
   @Query(value="SELECT content_id,title,image,num "
		 +"FROM (SELECT content_id,title,image,rownum as num "
		 +"FROM (SELECT content_id,title,image "
		 +"FROM dahye_hotel ORDER BY content_id ASC)) "
		 +"WHERE num BETWEEN :start AND :end",nativeQuery = true)
   public List<HotelListVO> hotelListData(@Param("start") int start,@Param("end") int end);
   
   public HotelEntity findByContentId(int content_id); // where => where fno=? => select *
}
