package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.BargainDao;
import com.javaeetest.entity.Bargain;

public class BargainDaoImpl extends BaseDaoImpl<Bargain> implements BargainDao {
	@Override
	public Bargain isBargain(int id) {
		// TODO Auto-generated method stub
		String hql = "select * from tb_bargain as bargain where bargain.bookId=?0";
		List<Bargain> bargain = find(hql, id);
		if (bargain != null && bargain.size() > 0) {

			return bargain.get(0);

		}

		return null;

	}

	/**
	 * 特价图书
	 */
	public List<Bargain> allBargain() {
		// TODO Auto-generated method stub
		String hql = "from Bargain as bargain where bargain.bargainStatus=1";

		List<Bargain> bargain = findByHql(hql);

		if (bargain != null && bargain.size() > 0) {
			return bargain;
		}

		return null;

	}

}
