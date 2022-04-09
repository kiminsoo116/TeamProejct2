package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
/*
 *  private String id;
	private String pwd;
	private String nic;
	private String name;
	private String addr1;
	private String addr2;
	private String email;
	private String tel;
	private String sex;
	private String post;
	private String admin;
	private Date birth;
 */
public interface signupMapper {
	
	@Insert("INSERT INTO member VALUES(#{id},#{pwd},#{nic},#{name},#{addr1},#{addr2},#{email},#{tel},#{sex},#{birth},#{post},#{admin})")
	public void memberSignUp(memberVO vo);
	
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int idchecking(String id);
	
	@Select("SELECT COUNT(*) FROM member WHERE nic=#{nic}")
	public int nicChecking(String nic);
	
	@Select("SELECT pwd||','||nic FROM member WHERE id=#{id}")
	public String loginChecking(String id);
	
	@Select("SELECT pwd FROM member WHERE id=#{id} AND tel=#{tel} AND name=#{name}" )
	public String findingPwdByTel(Map map);
	
	@Select("SELECT pwd FROM member WHERE id=#{id} AND email=#{email} AND name=#{name}" )
	public String findingPwdByEmail(Map map);
	
	@Select("SELECT id FROM member WHERE name=#{name} AND tel=#{tel}")
	public String findingIdByTel(Map map);
	
	@Select("SELECT id FROM member WHERE name=#{name} AND email=#{email}")
	public String findingIdByEmail(Map map);
}
