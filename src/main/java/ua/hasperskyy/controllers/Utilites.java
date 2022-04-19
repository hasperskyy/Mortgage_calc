package ua.hasperskyy.controllers;

import java.util.regex.Pattern;

public class Utilites {

	private String digit = "\\d+";
	private StringBuilder errorText = new StringBuilder();

	public boolean isDataCorrect(String data) {
		if (Pattern.matches(digit, data)) {
			return true;
		} else {
			return false;
		}
	}
	
	public StringBuilder getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText.append(errorText);
	}



	
}
