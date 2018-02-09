package com.ziw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	
	
	
	
}
