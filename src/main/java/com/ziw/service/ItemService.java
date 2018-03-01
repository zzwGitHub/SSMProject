package com.ziw.service;

import com.ziw.utilmodel.BootstrapTableResult;

public interface ItemService {

	int itemAdd();
	int saveItem();
	int testJdbcTemplate();
	
	/**
	 * 分页查询
	 *
	 * @author Ziw
	 * @date 2018年3月1日
	 */
	BootstrapTableResult itemList(int page, int rows, String searchText);
}
