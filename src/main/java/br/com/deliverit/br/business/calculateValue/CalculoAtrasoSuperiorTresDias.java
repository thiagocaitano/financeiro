package br.com.deliverit.br.business.calculateValue;

import br.com.deliverit.br.domain.ContaPagar;

public class CalculoAtrasoSuperiorTresDias implements CalculoAtraso  {

	@Override
	public Double calcular(ContaPagar contaPagar, long diasEmAtraso) {

		double multa = 0.03; // multa de 3%
		double juros = 0.0002; // juros de 0.02%

		double valorMulta = (contaPagar.getValorOriginal() * multa);
		double valorJuros = (contaPagar.getValorOriginal() * juros) * diasEmAtraso;
		
		return contaPagar.getValorOriginal() + valorMulta + valorJuros;
		
	}

}
