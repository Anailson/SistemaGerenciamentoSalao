package br.com.sistema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.Servico;
import br.com.sistema.repository.ClienteRepository;
import br.com.sistema.repository.ServicoRepository;

@Controller
public class ServicoController  {
	
	
	@Autowired
	private ServicoRepository servicoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastroservico")
	public ModelAndView inicio() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroservico");
		modelAndView.addObject("servicoobj", new Servico()); //CRIANDO NOVO OBJ PRA PEGAR OS DADOS EDICAÇÃO
		
		return modelAndView;
		
		
		
	}
	@RequestMapping(method = RequestMethod.POST,value = "**/salvarservico")
	public ModelAndView salvar(Servico servico) {
		
	   servicoRepository.save(servico);
	   ModelAndView andView = new ModelAndView("cadastro/cadastroservico");
	   Iterable<Servico> servicoIt = servicoRepository.findAll();
	   andView.addObject("servicos",servicoIt);
	   andView.addObject("servicoobj", new Servico());
	   
	   return andView;
	   
		
	}
	@RequestMapping(method = RequestMethod.GET, value ="/listaservicos")
	public ModelAndView servicos() {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastroservico");
		Iterable<Servico> servicoIt = servicoRepository.findAll();
		andView.addObject("servicos", servicoIt);
		andView.addObject("servicoobj", new Servico());
		
		return andView;
	}
	
	/*--EDITAR--*/
	@GetMapping("/editarservico/{idservico}")
	public ModelAndView editar(@PathVariable("idservico") Long idservico) {
		
		Optional<Servico> servico = servicoRepository.findById(idservico);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroservico");
		modelAndView.addObject("servicoobj",servico.get());//CARREGANDO OS OBJETOS
		
		return modelAndView;
		

	}
	

}
