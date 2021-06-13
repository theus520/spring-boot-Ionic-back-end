package com.matheusrabelo.mr.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheusrabelo.mr.domain.Cliente;
import com.matheusrabelo.mr.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	
	@Transactional(readOnly = true)
	Page<Pedido> findByCliente(Cliente cliente, PageRequest pageRequest);
}

