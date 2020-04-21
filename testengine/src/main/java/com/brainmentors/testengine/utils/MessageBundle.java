package com.brainmentors.testengine.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageBundle {
	@Autowired
	private MessageSource messageSource;
	private String lang;
	
	public MessageBundle() {
		lang = Lang.ENGLISH;
	}
	
	
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public  String getMessage(String key) { 
		 return messageSource.getMessage(key, null, null, new Locale(getLang()));
	}

}
