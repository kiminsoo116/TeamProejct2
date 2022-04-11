package com.sist.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;


import javax.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;

@Controller
public class MainController {
	@Autowired
	private clubDAO dao;
	
	
	@GetMapping("main/main.do")
	public String main_main(Model model,HttpServletRequest request) {
		int[] com=new int[16];
		List<clubVO> list=new ArrayList<clubVO>();
		getRand(com);
		for(int i=0;i<16;i++)
		{
			clubVO vo=dao.clubMainData(com[i]);
			list.add(vo);
		}
		
		
		model.addAttribute("list", list);
		
		return "main";
	}


	public void getRand(int[] com) {
		// TODO Auto-generated method stub
		int su=0;
		boolean bCheck=false;
		for(int i=0;i<16;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				su=(int)(Math.random()*70)+1;
				bCheck=false;
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		
	}
	
	
}
