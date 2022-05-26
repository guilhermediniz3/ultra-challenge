package com.example.demo.dto;

import java.util.List;

import com.example.demo.entities.Empresa;
import com.example.demo.entities.Funcionario;
import com.example.demo.entities.Meta;

public class EmpresaDTO {

	private Long id;
	private String nome;
	private String cnpj;
	private List<Meta> meta;
	private List<Funcionario> funcionario;

	public EmpresaDTO() {

	}

	public EmpresaDTO(Long id, String nome, String cnpj, List<Meta> meta, List<Funcionario> funcionario) {

		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.meta = meta;
		this.funcionario = funcionario;
	}

	public EmpresaDTO(Empresa entity) {

		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cnpj = entity.getCnpj();
		this.meta = entity.getMeta();
		this.funcionario = entity.getFuncionario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Meta> getMeta() {
		return meta;
	}

	public void setMeta(List<Meta> meta) {
		this.meta = meta;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
}
