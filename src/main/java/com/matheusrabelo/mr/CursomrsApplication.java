package com.matheusrabelo.mr;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheusrabelo.mr.Repositories.CategoriaRepository;
import com.matheusrabelo.mr.Repositories.CidadeRepository;
import com.matheusrabelo.mr.Repositories.ClienteRepository;
import com.matheusrabelo.mr.Repositories.EnderecoRepository;
import com.matheusrabelo.mr.Repositories.EstadoRepository;
import com.matheusrabelo.mr.Repositories.ItemPedidoRepository;
import com.matheusrabelo.mr.Repositories.PagamentoRepository;
import com.matheusrabelo.mr.Repositories.PedidoRepository;
import com.matheusrabelo.mr.Repositories.ProdutoRepository;
import com.matheusrabelo.mr.domain.Categoria;
import com.matheusrabelo.mr.domain.Cidade;
import com.matheusrabelo.mr.domain.Cliente;
import com.matheusrabelo.mr.domain.Endereco;
import com.matheusrabelo.mr.domain.Estado;
import com.matheusrabelo.mr.domain.ItemPedido;
import com.matheusrabelo.mr.domain.Pagamento;
import com.matheusrabelo.mr.domain.PagamentoComBoleto;
import com.matheusrabelo.mr.domain.PagamentoComCartao;
import com.matheusrabelo.mr.domain.Pedido;
import com.matheusrabelo.mr.domain.Produto;
import com.matheusrabelo.mr.domain.enums.EstadoPagamento;
import com.matheusrabelo.mr.domain.enums.TipoCliente;

@SpringBootApplication
public class CursomrsApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired

	private PagamentoRepository pagamentoRepository;

	@Autowired

	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomrsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletronicos");
		Categoria cat5 = new Categoria(null, "jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 100.00);
		Produto p4 = new Produto(null, "mesa de escritório", 200.00);
		Produto p5 = new Produto(null, "Toalha de banho", 60.00);
		Produto p6 = new Produto(null, "Colcha", 180.00);
		Produto p7 = new Produto(null, "Tv ", 1500.00);
		Produto p8 = new Produto(null, "Cortador de grama", 1000.00);
		Produto p9 = new Produto(null, "Abajour", 120.00);
		Produto p10 = new Produto(null, "Perfume", 130.00);
		Produto p11 = new Produto(null, "Pendente", 100.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Tocantins");
		Estado est2 = new Estado(null, "Rio de Janeiro");

		Cidade c1 = new Cidade(null, "Jalapão", est1);
		Cidade c2 = new Cidade(null, "Angra dos reis", est2);
		Cidade c3 = new Cidade(null, "Arraial do cabo", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "marcelo", "Marcelo@.com", "098373727272", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("061991450778", "90639925857743"));

		Endereco e1 = new Endereco(null, "rua flores", "300", "apto 303", "jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida matos", "105", "sala 840", "centro", "3848438", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/03/2021 10:40"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/02/2021 19:35 "), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2023 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
