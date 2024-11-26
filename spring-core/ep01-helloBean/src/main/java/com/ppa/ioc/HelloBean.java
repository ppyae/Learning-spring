package com.ppa.ioc;

import com.ppa.ioc.anno.MyAnno;

@MyAnno
public class HelloBean {
	
	public void hello() {
		System.out.println("Hello Ioc Container");
	}

}
