package com.menger.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.menger.entity.Contact;
import com.menger.util.XmlUtil;

public class ContactDaoImpl implements ContactDao {

	@Override
	public void addContact(Contact contact) {
		//1. 得到Document对象
		Document document = XmlUtil.getDocument();
		//2. 得到根元素
		Element root = document.getRootElement();
		//3. 添加contact
		Element contactElement = root.addElement("contact");
		//添加id，id自动产生
		String id = UUID.randomUUID().toString();
		contactElement.addAttribute("id", id);
		//添加其它的属性
		contactElement.addElement("name").addText(contact.getName());
		contactElement.addElement("gender").addText(contact.getGender());
		contactElement.addElement("age").addText(String.valueOf(contact.getAge()));
		contactElement.addElement("jiguan").addText(contact.getJiguan());
		contactElement.addElement("qq").addText(contact.getQq());
		contactElement.addElement("email").addText(contact.getEmail());
		//写入xml
		XmlUtil.writeXml(document);
	}

	@Override
	public void updateContact(Contact contact) {
		//解析XML文件
		Document document = XmlUtil.getDocument();
		//通过id进行查询
		Element element = (Element) document.selectSingleNode("//contact[@id='" + contact.getId() + "']");
		//修改
		element.element("name").setText(contact.getName());
		element.element("gender").setText(contact.getGender());
		element.element("age").setText(String.valueOf(contact.getAge()));
		element.element("jiguan").setText(contact.getJiguan());
		element.element("qq").setText(contact.getQq());
		element.element("email").setText(contact.getEmail());
		//写入XML
		XmlUtil.writeXml(document);
	}

	@Override
	public void deleteContact(String id) {
		//解析XML文件
		Document document = XmlUtil.getDocument();
		Element element = (Element) document.selectSingleNode("//contact[@id='" + id  + "']");
		element.detach();
		//写入XML
		XmlUtil.writeXml(document);
	}

	@Override
	public List<Contact> findAll() {
		// 创建集合对象
		List<Contact> contacts = new ArrayList<>();
		// 解析XML文件
		Document document = XmlUtil.getDocument();
		// 得到根元素
		Element root = document.getRootElement();
		// 得到所有的contact
		List<Element> elements = root.elements("contact");
		for (Element element : elements) {
			// 创建一个联系人对象
			Contact contact = new Contact();
			// 得到id属性的值
			contact.setId(element.attributeValue("id"));
			// 封装其它属性
			contact.setName(element.elementText("name"));
			contact.setGender(element.elementText("gender"));
			contact.setEmail(element.elementText("email"));
			contact.setJiguan(element.elementText("jiguan"));
			contact.setQq(element.elementText("qq"));
			contact.setAge(Integer.parseInt(element.elementText("age")));
			// 添加到集合中
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public Contact findById(String id) {
		Document document = XmlUtil.getDocument();
		Element element = (Element) document.selectSingleNode("//contact[@id='" + id  + "']");
		Contact contact = new Contact();
		contact.setId(element.attributeValue("id"));
		contact.setName(element.elementText("name"));
		contact.setGender(element.elementText("gender"));
		contact.setEmail(element.elementText("email"));
		contact.setJiguan(element.elementText("jiguan"));
		contact.setQq(element.elementText("qq"));
		contact.setAge(Integer.parseInt(element.elementText("age")));
		return contact;
	}

	@Override
	public boolean checkIfExist(String name) {
		Document document = XmlUtil.getDocument();
		Node node = document.selectSingleNode("//name[text()='" + name + "']");
		return node !=null ;
	}

}
