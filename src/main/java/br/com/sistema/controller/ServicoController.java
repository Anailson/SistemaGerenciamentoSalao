package br.com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.Servico;
import br.com.sistema.repository.ServicoRepository;

@Controller
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastroservico")
	public ModelAndView inicio() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroservico");
		modelAndView.addObject("clientes");
		
		return modelAndView;
		
	}
	@RequestMapping(method = RequestMethod.POST,value = "**/salvarservico")
	public String salvar(Servico servico) {
		
	   servicoRepository.save(servico);
		
		return "cadastro/cadastroservico";
	}
	@RequestMapping(method = RequestMethod.GET, value ="/listaservicos")
	public ModelAndView servicos() {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastroservico");
		Iterable<Servico> servicoIt = servicoRepository.findAll();
		andView.addObject("servicos", servicoIt);
		
		return andView;
	}
	

}
