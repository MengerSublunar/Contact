package com.menger.dao;

import java.util.List;
import com.menger.entity.Contact;

/**
 * 数据访问层
 */
public interface ContactDao {

	public void addContact(Contact contact); // 添加联系人

	public void updateContact(Contact contact);// 修改联系人

	public void deleteContact(String id); // 删除联系人

	public List<Contact> findAll();// 查询所有联系人

	public Contact findById(String id);// 根据编号查询联系人对象

	public boolean checkIfExist(String name);// 检查用户名是否重复

}
