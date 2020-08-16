package br.com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.Servico;
import br.com.sistema.repository.ServicoRepository;

@Controller
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastroservico")
	public String inicio() {

		return "cadastro/cadastroservico";
		
	}
	@RequestMapping(method = RequestMethod.POST,value = "**/salvarservico")
	public String salvar(Servico servico) {
		
	   servicoRepository.save(servico);
		
		return "cadastro/cadastroservico";
	}
	
	
	

}
