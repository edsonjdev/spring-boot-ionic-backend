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
import com.edson.cursomc.repositories.PagamentoRepository;
import com.edson.cursomc.repositories.PedidoRepository;
import com.edson.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informtica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Sofala");
		Estado est2 = new Estado(null, "Zambezia");
		
		Cidade c1 = new Cidade(null, "Beira", est1);
		Cidade c2 = new Cidade(null, "Mocuba", est2);
		Cidade c3 = new Cidade(null, "Quelimane", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Edna", "maria@gmail.com", "33333333333", TipoCliente.PESSOAFISICA);
		//salvamos telefones
		cli1.getTelefones().addAll(Arrays.asList("843333333", "82333332"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "22222222", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Picardo", "300", "Ruas 303", "Barca", "33333333", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("14/06/2019 21:48"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("14/05/2019 21:48"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("12/06/2019 20:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
