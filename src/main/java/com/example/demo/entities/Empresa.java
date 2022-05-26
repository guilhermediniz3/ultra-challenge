package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table (name = "empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<Meta> meta;
	
	@OneToMany(mappedBy = "empresa")
	@Cascade(CascadeType.ALL)
	private List<Funcionario> funcionario;
	
	public Empresa() {
		
	}
	

	public Empresa(Long id, String nome, String cnpj, List<Meta> meta, List<Funcionario> funcionario) {
		
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.meta = meta;
		this.funcionario = funcionario;
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


	@Override
	public int hashCode() {
		return Objects.hash(cnpj, funcionario, id, meta, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(funcionario, other.funcionario)
				&& Objects.equals(id, other.id) && Objects.equals(meta, other.meta) && Objects.equals(nome, other.nome);
	}
	
	
	
}
