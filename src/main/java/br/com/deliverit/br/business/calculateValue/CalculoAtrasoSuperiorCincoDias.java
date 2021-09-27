package br.com.deliverit.br.business.calculateValue;

import br.com.deliverit.br.domain.ContaPagar;

public class CalculoAtrasoSuperiorCincoDias implements CalculoAtraso  {

	@Override
	public Double calcular(ContaPagar contaPagar, long diasEmAtraso) {
		double multa = 0.05; // multa de 5%
		double juros = 0.0003; // juros de 0.03%

		double valorMulta = (contaPagar.getValorOriginal() * multa);
		double valorJuros = (contaPagar.getValorOriginal() * juros) * diasEmAtraso;
		
		return contaPagar.getValorOriginal() + valorMulta + valorJuros;
	}

}
