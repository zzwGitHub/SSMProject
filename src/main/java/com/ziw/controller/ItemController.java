package com.ziw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziw.service.ItemService;
import com.ziw.utilmodel.BootstrapTableResult;

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
	
	@RequestMapping("/itemList")
	@ResponseBody
	public BootstrapTableResult testList(int pageSize, int pageNumber, String searchText){
		
		BootstrapTableResult res = itemService.itemList(pageNumber, pageSize, searchText);
		return res;
	}
	
	
	
}
