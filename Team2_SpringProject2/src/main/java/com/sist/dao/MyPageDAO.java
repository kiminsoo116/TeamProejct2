//package com.sist.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import com.sist.vo.*;
//import com.sist.dao.*;
//import com.sist.mapper.*;
//import java.util.*;
//
//@Repository
//public class MyPageDAO {
//	@Autowired
//	private MyPageMapper mapper;
//	
//	//개인정보 수정
//	public void changeMyInfo(Map map) {
//		mapper.myInfoUpdate(map);
//	}
//	//개인정보 읽기
//	public memberVO readMyInfo(String id){
//		return mapper.readMyInfo(id);
//	}
//	
//	//찜한 모임 출력
//	public List<ClubVO> myWishClubData(String id){
//		return mapper.wishClubListData(id);
//	}
//	
//	//내가 가입한(만든)모임
//	public List<ClubVO> myClubListData(String id){
//		return mapper.myClubListData(id);
//	}
//}
