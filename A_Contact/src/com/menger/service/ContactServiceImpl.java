package com.menger.service;

import java.util.List;

import com.menger.dao.ContactDBImpl;
import com.menger.dao.ContactDao;
import com.menger.dao.ContactDaoImpl;
import com.menger.entity.Contact;
import com.menger.exception.NameExistException;

public class ContactServiceImpl implements ContactService {
	
	ContactDao contactDao = new ContactDBImpl();

	@Override
	public void addContact(Contact contact) throws NameExistException {
		if (contactDao.checkIfExist(contact.getName())) {
			throw new NameExistException("联系人" + contact.getName() + "已存在");
		}
		contactDao.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDao.updateContact(contact);
	}

	@Override
	public void deleteContact(String id) {
		contactDao.deleteContact(id);
	}

	@Override
	public List<Contact> findAll() {
		return contactDao.findAll();
	}

	@Override
	public Contact findById(String id) {
		return contactDao.findById(id);
	}

}
