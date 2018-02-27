package com.ziw.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.ziw.service.ItemService;

@RequestMapping("/item")
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String ItemAdd(){
		
		itemService.itemAdd();
		return null;
	}
	
	@RequestMapping("/test222")
	@ResponseBody
	public String ItemTest(){
		
		itemService.saveItem();
		return "result";
	}
	
	@RequestMapping("/testJdbc")
	@ResponseBody
	public String ItemTestJdbc(){
		
		itemService.testJdbcTemplate();
		return "result";
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public ModelAndView test3(){
		ModelAndView model = new ModelAndView();
		model.setViewName("result");
		return model;
	}
	
	
	
	
	
	
}
