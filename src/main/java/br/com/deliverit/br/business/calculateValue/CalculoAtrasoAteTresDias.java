package br.com.deliverit.br.business.calculateValue;

import br.com.deliverit.br.domain.ContaPagar;

public class CalculoAtrasoAteTresDias implements CalculoAtraso  {

	@Override
	public Double calcular(ContaPagar contaPagar, long diasEmAtraso) {
		double multa = 0.02; // multa de 2%
		double juros = 0.0001; // juros de 0.01%

		double valorMulta = (contaPagar.getValorOriginal() * multa);
		double valorJuros = (contaPagar.getValorOriginal() * juros) * diasEmAtraso;
		
		return contaPagar.getValorOriginal() + valorMulta + valorJuros;
	}

}
