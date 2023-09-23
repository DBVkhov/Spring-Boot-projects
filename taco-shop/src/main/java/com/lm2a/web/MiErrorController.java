package com.lm2a.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MiErrorController implements ErrorController {

	@Autowired
	ErrorAttributes errorAttributes;
	
	@RequestMapping("/error")
	public String handleError(WebRequest webRequest, Model model) {
		log.error("Ha ocurrido un error!!!");
		
		Map<String, Object> errores = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE));
		
		model.addAttribute("msg", errores.get("trace"));
		model.addAttribute("path", errores.get("path"));		
		
		//enviar email al encargado de mantenimiento
		return "error";
	}
}
