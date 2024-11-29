package com.ppa.aop.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.ppa.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppController {
	


}
