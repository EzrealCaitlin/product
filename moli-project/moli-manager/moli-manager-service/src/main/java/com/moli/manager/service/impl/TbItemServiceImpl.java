package com.moli.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moli.manager.mapper.TbItemMapper;
import com.moli.manager.pojo.TbItem;
import com.moli.manager.service.TbItemService;

@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	private TbItemMapper itemMapper;
	
	public TbItem getById(Long id) {
		return itemMapper.selectByPrimaryKey(id);
	}

}
