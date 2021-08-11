/**
 *
 */
package br.com.izabelrodrigues.tdd.service;

import java.math.BigDecimal;

import br.com.izabelrodrigues.tdd.modelo.Desempenho;
import br.com.izabelrodrigues.tdd.modelo.Funcionario;

/**
 * @author Izabel Rodrigues
 *
 */
public class ReajusteService {

	public void efetuarReajuste(Funcionario funcionario, Desempenho desempenho) {
		reajustarSalarioPorDesempenho(funcionario, desempenho.getFatorReajuste());
	}

	private void reajustarSalarioPorDesempenho(Funcionario funcionario, BigDecimal fatorDesempenho) {
		BigDecimal reajuste = funcionario.getSalario().multiply(fatorDesempenho);
		funcionario.reajustarSalario(reajuste);
	}

}
