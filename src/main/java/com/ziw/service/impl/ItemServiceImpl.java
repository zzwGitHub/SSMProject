package com.ziw.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ziw.mapper.TbContentMapper;
import com.ziw.mapper.TbItemMapper;
import com.ziw.pojo.TbContent;
import com.ziw.pojo.TbItem;
import com.ziw.pojo.TbItemExample;
import com.ziw.pojo.TbItemExample.Criteria;
import com.ziw.service.ItemService;
import com.ziw.util.DBHelper;
import com.ziw.utilmodel.BootstrapTableResult;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	@Qualifier("DBHelper")
	private DBHelper DBHelper;
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbContentMapper contentMapper;
	
	@Value("${AD1_WIDTH}")
	private String AD1_WIDTH;
	
	public int itemAdd() {
		System.out.println(AD1_WIDTH);
		TbItem item = itemMapper.selectByPrimaryKey((long)536563);
		System.out.println(item.getPrice());
		return 1;
	}
	
	/**
	 * 测试事务
	 */
	@Transactional
	public int saveItem() {
		TbContent content = new TbContent();
		content.setId(genItemId());
		content.setCategoryId(genItemId());
		content.setTitle("test0045");
		contentMapper.insert(content);
		
//		int a = 1/0;
//		
		TbContent content1 = new TbContent();
		content1.setId(genItemId());
		content1.setCategoryId(genItemId());
		content1.setTitle("test003");
		contentMapper.insert(content1);
		
		return 1;
	}
	
	public int testJdbcTemplate() {
		int res = DBHelper.queryCount("select count(1) from tb_content;");
		System.out.println(res);
		return 0;
	}
	
	
	@Override
	public BootstrapTableResult itemList(int page, int rows, String searchText) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		if(searchText != null && !"".equals(searchText)){
			Criteria criteria = example.createCriteria();
			criteria.andTitleLike("%" + searchText + "%");
			
			Criteria criteria2 = example.or();
			criteria2.andSellPointLike("%" + searchText + "%");
		}
		List<TbItem> list = itemMapper.selectByExample(example);
		//取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		BootstrapTableResult result = new BootstrapTableResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		//返回结果
		return result;
	}

	
	
	
	
	
	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	
	


}
