package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa , Long>{
	


}
