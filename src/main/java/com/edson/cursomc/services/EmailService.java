package com.edson.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.edson.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrdeConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
