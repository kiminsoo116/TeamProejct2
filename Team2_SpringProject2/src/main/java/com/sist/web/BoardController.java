package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.dao.BoardDAO;
import com.sist.vo.ReplyVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardDAO board;
	
	@GetMapping("list.do")
	public String boardList(Model m, @RequestParam(defaultValue ="1", required = true) int p,@RequestParam(defaultValue ="", required = true)String t,@RequestParam(defaultValue ="b_title", required = true) String q) {
		m.addAttribute("list",board.getList(p,q,t));
		m.addAttribute("total",board.getCount(q,t));
		m.addAttribute("q",q);
		m.addAttribute("t",t);
		return "board/list";
	}
	
	@GetMapping("write.do")
	public String write() {
		return "board/write";
	}
	@PostMapping("dowrite.do")
	public String dowrite(String b_title, String b_content) {
		board.dowrite(b_title,b_content);
		return "redirect:/board/list.do";
	}
	
	@GetMapping("detail.do")
	@Transactional(rollbackFor = Exception.class)
	public String detail(int id, Model m) {
		board.uphit(id);
		m.addAttribute("detail",board.detail(id));
		m.addAttribute("vo",new ReplyVO());
		return "board/detail";
	}
	
	@GetMapping("update.do")
	public String update(Model m,int id) {
		m.addAttribute("detail",board.detail(id));
		return "board/update";
	}
	
	@PostMapping("doupdate.do")
	public String update(int b_no, String b_title, String b_content) {
		board.update(b_title, b_content, b_no);
		return "redirect:/board/detail.do?id="+b_no;
	}
	

}
