package com.matheusrabelo.mr.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusrabelo.mr.Repositories.CidadeRepository;
import com.matheusrabelo.mr.domain.Cidade;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}