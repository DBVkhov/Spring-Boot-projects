package com.lm2a.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lm2a.model.Order;
import com.lm2a.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/current")
	public String orderForm(Model model) {
		//model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, Model model, SessionStatus sessionStatus) {
		if(errors.hasErrors()) {
			model.addAttribute("order", order);
			return "orderForm";
		}
		
		log.info("Orden recibida: "+order);
		orderRepository.save(order);
		sessionStatus.setComplete();
		//pasar a persistencia la Orden
		return "redirect:/";
	}
}
