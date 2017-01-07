package com.menger.service;

import java.util.List;
import com.menger.entity.Contact;
import com.menger.exception.NameExistException;

public interface ContactService {
	
	public void addContact(Contact contact) throws NameExistException; // 添加联系人，如果联系人已经存在，则抛出异常

	public void updateContact(Contact contact);// 修改联系人

	public void deleteContact(String id); // 删除联系人

	public List<Contact> findAll();// 查询所有联系人

	public Contact findById(String id);// 根据编号查询联系人对象
	
}
