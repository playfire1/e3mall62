package cn.hmy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hmy.mapper.TbItemMapper;
import cn.hmy.pojo.TbItem;
import cn.hmy.pojo.TbItemExample;
import cn.hmy.pojo.TbItemExample.Criteria;
import cn.hmy.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem findItemById(long id) {
		//TbItem item = itemMapper.selectByPrimaryKey(id);
		
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
