package com.javaeetest.dao;

import java.util.List;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.Bargain;

public interface BargainDao extends BaseDao<Bargain> {
	
	public Bargain isBargain(int id);
	public List<Bargain> allBargain();
}
