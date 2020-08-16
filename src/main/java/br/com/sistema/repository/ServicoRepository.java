package br.com.sistema.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.model.Servico;

@Transactional
@Repository
public interface ServicoRepository extends CrudRepository<Servico, Long>{

}
