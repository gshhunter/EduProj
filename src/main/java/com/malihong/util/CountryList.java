package com.malihong.util;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;


public class CountryList {
	
	public static Map<String, String> getCountryList(Locale locale) {
		
		String[] locales = Locale.getISOCountries();
		Map<String, String> countryList = new LinkedHashMap<String, String>();
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			countryList.put(obj.getCountry(), obj.getDisplayCountry(locale));
		}
		return countryList;
	}
	
	public static void main(String[] args) {

		CountryList.getCountryList(Locale.CHINESE);
		
	}

}
