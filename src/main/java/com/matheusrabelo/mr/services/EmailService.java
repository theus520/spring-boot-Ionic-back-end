package com.matheusrabelo.mr.services;

import org.springframework.mail.SimpleMailMessage;

import com.matheusrabelo.mr.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
