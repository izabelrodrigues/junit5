/**
 *
 */
package br.com.izabelrodrigues.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.izabelrodrigues.tdd.modelo.Desempenho;
import br.com.izabelrodrigues.tdd.modelo.Funcionario;

/**
 * @author Izabel Rodrigues
 *
 */
public class ReajusteServiceTest {

	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoFuncionarioNaoBateuAMeta() {

		Funcionario funcionario = new Funcionario("FUNC_SALARIO_IGUAL_DEZ_MIL", LocalDate.now(),
				new BigDecimal(10000.00));
		ReajusteService reajusteService = new ReajusteService();
		reajusteService.efetuarReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("10300.00"), funcionario.getSalario(),
				"Salario do funcionário com desempenho a desejar deveria ter aumento de 3%");
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoFuncionarioTeveDesempenhoBom() {

		Funcionario funcionario = new Funcionario("FUNC_SALARIO_IGUAL_DEZ_MIL", LocalDate.now(),
				new BigDecimal(10000.00));
		ReajusteService reajusteService = new ReajusteService();
		reajusteService.efetuarReajuste(funcionario, Desempenho.BOM);

		assertEquals(new BigDecimal("11500.00"), funcionario.getSalario(),
				"Salario do funcionário com desempenho bom deveria ter aumentado de 15%");
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoFuncionarioTeveDesempenhoBom() {

		Funcionario funcionario = new Funcionario("FUNC_SALARIO_IGUAL_DEZ_MIL", LocalDate.now(),
				new BigDecimal(10000.00));
		ReajusteService reajusteService = new ReajusteService();
		reajusteService.efetuarReajuste(funcionario, Desempenho.OTIMO);

		assertEquals(new BigDecimal("12000.00"), funcionario.getSalario(),
				"Salario do funcionário com desempenho ótimo deveria ter aumentado de 20%");
	}

}
