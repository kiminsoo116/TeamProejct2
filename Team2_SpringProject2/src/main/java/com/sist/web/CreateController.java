package com.sist.web;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.CreateVO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class CreateController {

	@Autowired
	private CreateDAO dao;
	
	@GetMapping("puzzlecreate/create.do")
	public String puzzle_create()
	{
		return "puzzlecreate/create";
	}
	   @PostMapping("puzzlecreate/insert_ok.do")
	   public String puzzle_insert_ok(CreateVO vo,HttpSession session)
	   {
		   	String id=(String)session.getAttribute("id");
		   // vo단위로 값을 받는다  => 커맨드 객체 (vo , [] , list)
		   try {
			   System.out.println(vo.getDb_day());
			   Date date=new Date();
			  // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//   vo.setP_date(sdf.parse(vo.getDb_day()));
			   vo.setId(id);
			   vo.setCl_no(11);
			   dao.puzzle_create(vo);
			   
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   return "redirect:../puzzle/main.do";
	   }
		/*
		 * @GetMapping("puzzle/main.do") public String puzzle_view(int pno,Model model)
		 * { List<CreateVO>plist=dao.puzzle_view(pno);
		 * 
		 * model.addAttribute("plist",plist); return "puzzle"; }
		 */
}
