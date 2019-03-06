package com.daotest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daotest.service.Daoservice;

@Controller
public class Daocontroller {
	// service
	@Autowired
	Daoservice ds;
	
	
	// request : GET / daotest.do, form : daotest.jsp	
	@GetMapping("/daotest.do")
	public String daotestGet() {
		System.out.println("ddd");
		return "daotest";
	}
	// request : POST / daotest.do, insert : daolist.jsp
	@RequestMapping(value="/daotest.do", method = RequestMethod.POST)
	public String daotestPost(@RequestParam Map<String, String> pm) {
		ds.insert(pm);
		return "redirect:/list.do";
	}
	
	@RequestMapping("/list.do")
	public ModelAndView daotestSelect(Model m) {
		ModelAndView mv = new ModelAndView();
		ArrayList<HashMap<String,String>> list = ds.select();
		mv.addObject("list", list);
		mv.setViewName("daolist");
		
		return mv;
	}
	
}
