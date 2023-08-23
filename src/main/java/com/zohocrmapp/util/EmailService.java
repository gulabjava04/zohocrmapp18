package com.zohocrmapp.util;

public interface EmailService {
	public void sendEmail(String to, String sub, String emailBody);
}
