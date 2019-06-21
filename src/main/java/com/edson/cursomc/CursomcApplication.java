package com.edson.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edson.cursomc.domain.Categoria;
import com.edson.cursomc.domain.Cidade;
import com.edson.cursomc.domain.Cliente;
import com.edson.cursomc.domain.Endereco;
import com.edson.cursomc.domain.Estado;
import com.edson.cursomc.domain.ItemPedido;
import com.edson.cursomc.domain.Pagamento;
import com.edson.cursomc.domain.PagamentoComBoleto;
import com.edson.cursomc.domain.PagamentoComCartao;
import com.edson.cursomc.domain.Pedido;
import com.edson.cursomc.domain.Produto;
import com.edson.cursomc.domain.enums.EstadoPagamento;
import com.edson.cursomc.domain.enums.TipoCliente;
import com.edson.cursomc.repositories.CategoriaRepository;
import com.edson.cursomc.repositories.CidadeRepository;
import com.edson.cursomc.repositories.ClienteRepository;
import com.edson.cursomc.repositories.EnderecoRepository;
import com.edson.cursomc.repositories.EstadoRepository;
import com.edson.cursomc.repositories.ItemPedidoRepository;
import com.edson.cursomc.repositories.PagamentoRepository;
import com.edson.cursomc.repositories.PedidoRepository;
import com.edson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
