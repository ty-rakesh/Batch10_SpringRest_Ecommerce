package com.te.commercerest.service;

import java.util.List;


import com.te.commercerest.beans.ItemBean;

public interface AdminService {
	
	
	public boolean addItem(ItemBean infoBean);
	public ItemBean getItemData(Integer iid);

	public List<ItemBean> getAllItemDetails();
	

	public boolean deleteItem(Integer iid);
}