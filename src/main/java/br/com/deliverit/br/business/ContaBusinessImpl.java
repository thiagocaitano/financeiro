package br.com.deliverit.br.business;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliverit.br.business.calculateValue.CalculoAtraso;
import br.com.deliverit.br.business.calculateValue.CalculoAtrasoAteTresDias;
import br.com.deliverit.br.business.calculateValue.CalculoAtrasoSuperiorCincoDias;
import br.com.deliverit.br.business.calculateValue.CalculoAtrasoSuperiorTresDias;
import br.com.deliverit.br.domain.ContaPagar;
import br.com.deliverit.br.repository.ContaRepository;

@Service
public class ContaBusinessImpl implements ContaBusiness {
	
	@Autowired
	private ContaRepository repository;
	
	public void insereContaPagar(ContaPagar contaPagar) {
		verificaContaEmAtraso(contaPagar);
		repository.save(contaPagar);
	}
	
	public List<ContaPagar> listarContasPagar(ContaPagar contaPagar){
		return repository.findAll();
	}

	private void verificaContaEmAtraso(ContaPagar contaPagar){
		
		long diasEmAtraso = 0;
		Double valor = contaPagar.getValorOriginal();
		CalculoAtraso calculo = null;
		
		if(contaPagar.getDataPagamento().after(contaPagar.getDataVencimento())) {

			long milisegundos = Math.abs(contaPagar.getDataVencimento().getTime() - contaPagar.getDataPagamento().getTime());
			diasEmAtraso = TimeUnit.DAYS.convert(milisegundos, TimeUnit.MILLISECONDS);
			
			if(diasEmAtraso <= 3) 
				calculo = new CalculoAtrasoAteTresDias();
			else if(diasEmAtraso == 4 || diasEmAtraso == 5) 
				calculo = new CalculoAtrasoSuperiorTresDias();
			else if(diasEmAtraso >= 6) 
				calculo = new CalculoAtrasoSuperiorCincoDias();
			
			valor = calculo.calcular(contaPagar, diasEmAtraso);
		} 

		contaPagar.setValorCorrigido(valor);
		contaPagar.setQtdDiasAtraso(diasEmAtraso);
	}
	
}
