package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper board;
	
	public List<BoardVO> getList(int p, String q, String t) {
		int start = ((p-1)*10)+1;
		int end=p*10;
		return board.getList(start,end,q,t);
	};
	public int getCount(String q, String t) {
		return board.getCount(q,t);
	}
	public BoardVO detail(int id) {
		return board.getDetail(id);
	}
	public int dowrite(String b_title, String b_content) {
		return board.dowrite(b_title,b_content);
	}
	public void update(String b_title, String b_content,int b_no) {
		board.update(b_title,b_content,b_no);
	}
	public void uphit(int b_no) {
		board.uphit(b_no);
	}

}
