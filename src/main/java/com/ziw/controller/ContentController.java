package com.ziw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziw.pojo.TbContent;
import com.ziw.service.ContentService;
import com.ziw.utilmodel.BootstrapTableResult;

@RequestMapping("/content")
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/contentList")
	@ResponseBody
	public BootstrapTableResult contentList(int pageSize, int pageNumber, String searchText){
		
		BootstrapTableResult result = contentService.contentList(pageNumber,pageSize);
		
		return result;
	}
	
	@RequestMapping("/testList")
	@ResponseBody
	public BootstrapTableResult testList(int pageSize, int pageNumber, String searchText){
		
		System.out.println(searchText);
		
		BootstrapTableResult result = new BootstrapTableResult();
		
		List<TbContent> list = new ArrayList<TbContent>();
		
		TbContent tbContent = new TbContent();
		tbContent.setContent("CCCCCCC");
		tbContent.setPic("PPPPP");
		
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		list.add(tbContent);
		
		result.setTotal(40);
		result.setRows(list);
		
		return result;
	}
	
	@RequestMapping("/toContentPage")
	@ResponseBody
	public ModelAndView toContentPage(){
		
		ModelAndView model = new ModelAndView();
		model.setViewName("content_list");
		
		return model;
	}
}
