package com.te.commercerest.dao;

import java.util.List;

import com.te.commercerest.beans.ItemBean;

public interface AdminDao {
	
	public ItemBean getItemData(Integer iid);

	public boolean addItem(ItemBean infoBean);
	public List<ItemBean> getAllItemDetails();

	
	
	public boolean deleteItem(Integer iid);
}