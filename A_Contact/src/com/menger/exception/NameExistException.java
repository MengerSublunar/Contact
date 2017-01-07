package com.menger.exception;

/**
 * 自定义异常，用户名已经存在
 */
public class NameExistException extends Exception {

	public NameExistException(String message) {
		super(message);
	}

}
