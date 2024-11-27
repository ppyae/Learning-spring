package com.ppa.depen.xml;

public class MyApp {
	
	private MyService service;
	
	public MyApp(MyService service) {
		this.service = service;
	}
	
	public void myApp() {
		service.serviceMethod();
	}

}
