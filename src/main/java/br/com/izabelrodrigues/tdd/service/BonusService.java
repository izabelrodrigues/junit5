/**
 *
 */
package br.com.izabelrodrigues.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.izabelrodrigues.tdd.modelo.Funcionario;

/**
 * @author Izabel Rodrigues
 *
 */
public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {

		BigDecimal salario = funcionario.getSalario();
		if (salario.compareTo(new BigDecimal(10000.00)) > 0) {
			return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		}
		return new BigDecimal("0.10").multiply(salario).setScale(2, RoundingMode.HALF_UP);
	}

}
