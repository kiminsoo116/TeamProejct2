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
		int grade =dao.ismember(session, cl);
		m.addAttribute("grade",grade);
		m.addAttribute("cl",cl);
		return "puzzle";
	}
}
