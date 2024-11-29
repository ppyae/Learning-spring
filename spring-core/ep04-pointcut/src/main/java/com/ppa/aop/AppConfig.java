package com.ppa.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages =  {"com.ppa.aop","com.ppa.aop.util"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
