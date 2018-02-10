package com.moli.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.manager.pojo.TbItem;
import com.moli.manager.service.TbItemService;

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	private TbItemService itemService;
	
	@RequestMapping("/getById/{id}")
	@ResponseBody
	public TbItem getById(@PathVariable Long id){
		TbItem item = itemService.getById(id);
		System.out.println(item.getId()+","+item.getTitle());
		return item;
	}
}
