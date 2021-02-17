package br.com.teste.gastoportaltransparencia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.gastoportaltransparencia.persistence.entity.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
	
}
