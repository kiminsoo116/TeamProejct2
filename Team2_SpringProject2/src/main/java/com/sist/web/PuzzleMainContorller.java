package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.memberDAO;

@Controller
public class PuzzleMainContorller {
	
	@Autowired
	memberDAO dao;
	
	@GetMapping("/puzzle/{cl}/main.do")
	public String club_main(Model m, HttpSession session ,@PathVariable int cl ) {
		int grade =dao.ismember(session, cl);
		m.addAttribute("grade",grade);
		m.addAttribute("cl",cl);
		return "puzzle";
	}
	
	
	@GetMapping("/puzzle/{cl}/dojoin.do")
	public String dojoin(Model m, HttpSession session ,@PathVariable int cl) {
		int grade =dao.ismember(session, cl);
		m.addAttribute("grade",grade);
		m.addAttribute("cl",cl);
		
		dao.clubJoin(session,cl);
		return "redirect:/puzzle/"+cl+"/main.do";
	}
	
	@GetMapping("/puzzle/{cl}/canceljoin.do")
	public String canceljoin(Model m, HttpSession session ,@PathVariable int cl) {
		int grade =dao.ismember(session, cl);
		m.addAttribute("grade",grade);
		m.addAttribute("cl",cl);
		
		dao.cancelJoin(session,cl);
		return "redirect:/puzzle/"+cl+"/main.do";
	}
	
}
