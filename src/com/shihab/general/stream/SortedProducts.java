package com.shihab.general.stream;

public class SortedProducts {

	public String getBarCode() {
		return BarCode;
	}

	public void setBarCode(String barCode) {
		BarCode = barCode;
	}

	private String BarCode;
	
	public SortedProducts(String a) {
		BarCode=a;
	}


}