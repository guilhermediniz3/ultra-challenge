package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmpresaDTO;
import com.example.demo.entities.Empresa;
import com.example.demo.entities.Funcionario;
import com.example.demo.repositories.EmpresaRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	@Transactional(readOnly = true)
	public List<EmpresaDTO> findAll() {
		List<Empresa> list = repository.findAll();
		List<EmpresaDTO> listDTO = list.stream().map(x -> new EmpresaDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
	@Transactional(readOnly = true)
	public EmpresaDTO findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		Empresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
		return new EmpresaDTO(entity );
	}

	@Transactional
	public EmpresaDTO insert(EmpresaDTO dto) {
		Empresa entity = new Empresa();
		entity.setNome(dto.getNome());
		entity.setCnpj(dto.getCnpj());
		entity.getFuncionario().clear();
		entity = repository.save(entity);
		return new EmpresaDTO(entity);
	}

	
	


	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			}
			catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException("id not found"+ "-"+ id);
			}
			catch(DataIntegrityViolationException e ) {
				throw new DatabaseException("integrity violation categoria já possui associações");
			}
		
	}

}
