package br.com.exposicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exposicao.model.Exhibition;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long>{

}
