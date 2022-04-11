package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.*;


import com.sist.vo.clubVO;

public interface clubMapper {
	// Insert 동아리 생성
	@Insert("INSERT INTO club VALUES(cl_no_seq.nextval,#{cl_poster},#{cl_content},#{cl_head},#{cl_loc},#{cl_category},#{cl_name})")
	public void clubInsert(clubVO vo);
	
	// Insert 회원등급 생성
	@Insert("INSERT INTO grade VALUES(1,#{id},#{cl_no})")
	public void gradeInsert(Map map);
	
	@Select("SELECT MAX(cl_no) FROM CLUB")
	public int clubmax();
	
	@Select("SELECT cl_no,cl_name,cl_poster,cl_content "
			 +"FROM club "
			 +"WHERE cl_no=#{cl_no}")
	  public clubVO clubMainData(int cl_no);
	
	 //3. 글쓰기 => 파일 업로드 
	 
}
