package com.menger.util;

import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * XML的工具类
 * 1. 用来读取XML文件
 * 2. 用来写入XML文件
 */
public class XmlUtil {
	
	private static String CONTACT_FILE = "D:/MengerDeveloperWorkspaces/MyEclipse/A_Contact/contact.xml";
	
	/**
	 * 得到一个XML文档对象
	 * @return
	 */
	public static Document getDocument() {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(CONTACT_FILE);
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
			//1. 异常还是抛出
			//2. 不是必须处理
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 写入一个XML文件
	 */
	public static void writeXml(Document document) {
		FileOutputStream fos = null;
		XMLWriter out  = null;
		OutputFormat of = OutputFormat.createPrettyPrint();
		try {
			fos = new FileOutputStream(CONTACT_FILE);
			out = new XMLWriter(fos, of);
			out.write(document);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			if (out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
	}
}
