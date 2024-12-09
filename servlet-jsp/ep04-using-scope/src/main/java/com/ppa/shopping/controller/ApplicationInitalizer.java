package com.ppa.shopping.controller;

import java.util.Set;

import com.ppa.shopping.model.ProductModel;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class ApplicationInitalizer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		ctx.setAttribute("productModel", new ProductModel());
		
	}

}
