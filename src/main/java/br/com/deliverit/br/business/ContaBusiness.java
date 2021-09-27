package br.com.deliverit.br.business;

import java.util.List;


import br.com.deliverit.br.domain.ContaPagar;

public interface ContaBusiness {

	public void insereContaPagar(ContaPagar contaPagar);
	public List<ContaPagar> listarContasPagar(ContaPagar contaPagar);

}
