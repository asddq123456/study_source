package com.jdbc.main;

import com.spring.view.View;
import com.spring.view.ViewImpl;

public class Main {

	static private View view;
	
	static {
		view = new ViewImpl();
		//((ViewImpl)view).setService(service);
	}
	
	public static void main(String[] args) {
		
		view.mainView();
	}

}




