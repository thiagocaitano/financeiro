package br.com.deliverit.br.business.calculateValue;

import br.com.deliverit.br.domain.ContaPagar;

public interface CalculoAtraso {

	public Double calcular(ContaPagar contaPagar, long diasEmAtraso);
	
}
