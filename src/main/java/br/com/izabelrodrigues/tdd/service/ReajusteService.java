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
		switch (desempenho) {
		case A_DESEJAR:
			reajustarSalarioPorDesempenhoADesejar(funcionario);
			break;
		case BOM:
			reajustarSalarioPorDesempenhoBom(funcionario);
			break;
		case OTIMO:
			reajustarSalarioPorDesempenhoOtimo(funcionario);

		default:
			break;
		}

	}

	private void reajustarSalarioPorDesempenhoOtimo(Funcionario funcionario) {
		BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
		funcionario.reajustarSalario(reajuste);

	}

	private void reajustarSalarioPorDesempenhoBom(Funcionario funcionario) {
		BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
		funcionario.reajustarSalario(reajuste);

	}

	private void reajustarSalarioPorDesempenhoADesejar(Funcionario funcionario) {
		BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
		funcionario.reajustarSalario(reajuste);
	}

}
