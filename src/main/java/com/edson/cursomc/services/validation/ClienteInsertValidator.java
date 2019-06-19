package com.edson.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.edson.cursomc.domain.enums.TipoCliente;
import com.edson.cursomc.dto.ClienteNewDTO;
import com.edson.cursomc.resources.exception.FieldMessage;
import com.edson.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
	
		List<FieldMessage> list = new ArrayList<>();
		// inclua os testes aqui, inserindo erros na lista
		//cpf
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOucnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
		}
		
		//cnpj
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOucnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
		}
		
	
	
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			.addPropertyNode(e.getFieldName()).addConstraintViolation();
			}
		return list.isEmpty();
	}

}