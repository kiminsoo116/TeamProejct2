package com.sist.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.*;

import com.sist.vo.clubVO;
import com.sist.vo.memberVO;

@Repository
public class clubDAO {
	@Autowired
	private clubMapper mapper;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void transaction(String id,clubVO vo) {
		mapper.clubInsert(vo);
		int cl_no=mapper.clubmax();
		Map map=new HashMap ();
		map.put("id", id);
		map.put("cl_no",cl_no);
		mapper.gradeInsert(map);
		
	}
	
	public clubVO clubMainData(int cl_no)
	   {
		   return mapper.clubMainData(cl_no);
	   }
	
	

}
