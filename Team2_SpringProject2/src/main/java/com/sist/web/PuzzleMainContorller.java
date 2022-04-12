package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sist.dao.memberDAO;

@Controller
public class PuzzleMainContorller {
	
	@Autowired
	memberDAO dao;
	
	@GetMapping("puzzle/{cl}/main.do")
	public String puzzle_main(Model m, HttpSession session ,@PathVariable int cl ) {
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			id="";
		}
		Integer tmp = dao.ismember(id,cl);
		int grade =0;
		if (tmp==null) {
			System.out.println("널이다");
		}else {
			grade=tmp;
		}
		m.addAttribute("grade",grade);
		return "puzzle";
	}
}
