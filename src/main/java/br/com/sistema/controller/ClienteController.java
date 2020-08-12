package br.com.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import br.com.sistema.model.Cliente;
import br.com.sistema.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastrocliente")
	public ModelAndView inicio() {
		
		//PASSANDO OBJETO PARA INICIA A TELA
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastrocliente");
		modelAndView.addObject("clienteobj", new Cliente());
		return modelAndView;
	}
	
	//CADASTRAR CLIENTE
	@RequestMapping(method = RequestMethod.POST, value = "/salvarcliente")
	public ModelAndView salvar(Cliente cliente) {
		clienteRepository.save(cliente);
		
		/*Salvando os dados na lista de clientes*/
		ModelAndView andView = new ModelAndView("cadastro/cadastrocliente");
		Iterable<Cliente> clienteIt = clienteRepository.findAll();
		andView.addObject("clientes", clienteIt);
		andView.addObject("clienteobj", new Cliente());
		
		return andView;
	}
	
	//LISTRAR CLIENTES
	@RequestMapping(method = RequestMethod.GET, value = "/listaclientes")
	public ModelAndView clientes() {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastrocliente");
		Iterable<Cliente> clienteIt = clienteRepository.findAll();
		andView.addObject("clientes", clienteIt);
		andView.addObject("clienteobj", new Cliente());
		
		return andView;
	}
	
	/*------------------METODO DE EXCLUIR-------------------------*/
	@GetMapping("/excluircliente/{idcliente}")
	public ModelAndView excluir(@PathVariable("idcliente") Long idcliente){
		
		
		clienteRepository.deleteById(idcliente); 
		
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastrocliente");
		modelAndView.addObject("clientes", clienteRepository.findAll());
		modelAndView.addObject("clienteobj", new Cliente()); 
	   
		return modelAndView;
		
	}

}
