//package com.sist.mapper;
//import java.util.*;
//import com.sist.vo.*;
//
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
///*
// *  private String id;
//	private String pwd;
//	private String nic;
//	private String name;
//	private String addr1;
//	private String addr2;
//	private String email;
//	private String tel;
//	private String sex;
//	private String post;
//	private int admin;
//	private String birth;
// */
//public interface MyPageMapper {
//	
//	//개인정보 읽기
//	@Select("SELECT * FROM member WHERE id=#{id}")
//	public memberVO readMyInfo(String id);
//	
//	//찜한 모임 출력
//	@Select("SELECT cl_poster,cl_head,cl_loc,c_no " + 
//			"FROM club c WHERE c.cl_no=(SELECT w.cl_no "
//			+ "FROM wish w WHERE w.id=#{id} ORDER BY w_no ASC)")
//	public List<ClubVO> wishClubListData(String id);
//	
//	//내가 가입한 (만든) 모임
//	@Select("SELECT cl_poster,cl_head,cl_loc,c_no "
//			+ "FROM club WHERE id=#{id}")
//	public List<ClubVO> myClubListData(String id);
//	
//	//카테고리 수정
//	
//	//내정보 수정
//	@Update("UPDATE member SET pwd=#{pwd},nic=#{nic},name=#{name},"
//			+ "addr1=#{addr1},addr2=#{addr2},email=#{email},tel=#{tel},"
//			+ "sex=#{sex},post=#{post},admin=#{admin},birth=#{birth} "
//			+ "WHERE id=#{id}")
//	public void myInfoUpdate(Map map);
//	
//}
