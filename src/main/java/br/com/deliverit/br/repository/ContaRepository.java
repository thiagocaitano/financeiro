package br.com.deliverit.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deliverit.br.domain.ContaPagar;

@Repository
public interface ContaRepository extends JpaRepository<ContaPagar, Long>, ContaRepositoryCustom {

}
