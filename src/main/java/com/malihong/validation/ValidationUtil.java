package com.malihong.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static final Pattern VALID_EMAIL_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean isEmail(String email) {
		Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
		return matcher.find();
	}
}
