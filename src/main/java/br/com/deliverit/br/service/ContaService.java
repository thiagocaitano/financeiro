package br.com.deliverit.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliverit.br.business.ContaBusiness;
import br.com.deliverit.br.domain.ContaPagar;

@RestController
@RequestMapping("conta")
public class ContaService {
	
	@Autowired
	private ContaBusiness business;

	@RequestMapping(method = RequestMethod.POST, produces="application/json")
	public void save(@RequestBody ContaPagar conta){
		business.insereContaPagar(conta);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public List<ContaPagar> list(ContaPagar conta){
		return business.listarContasPagar(conta);
	}
}
