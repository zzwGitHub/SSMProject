package com.ziw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziw.mapper.TbContentMapper;
import com.ziw.pojo.TbContent;
import com.ziw.pojo.TbContentExample;
import com.ziw.pojo.TbContentExample.Criteria;
import com.ziw.service.ContentService;
import com.ziw.utilmodel.BootstrapTableResult;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public BootstrapTableResult contentList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbContentExample example = new TbContentExample();
//		Criteria criteria = example.createCriteria();
//		criteria.a
		List<TbContent> list = contentMapper.selectByExample(example);
		//取查询结果
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		BootstrapTableResult result = new BootstrapTableResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		//返回结果
		return result;
	}

}
