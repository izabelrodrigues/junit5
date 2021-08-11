package br.com.izabelrodrigues.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.izabelrodrigues.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaRetornarBonusZeroQuandoSalarioMaiorQueDezMil() {

		Funcionario funcionario = new Funcionario("FUNC_SALARIO_MAIOR", LocalDate.now(), new BigDecimal(25000.00));
		BonusService bonusService = new BonusService();
		BigDecimal bonusCalculado = bonusService.calcularBonus(funcionario);

		BigDecimal bonusEsperado = new BigDecimal("0.00");
		assertEquals(bonusEsperado, bonusCalculado, "Sal�rios maiores que R$10000,00 n�o deveria receber b�nus!");
	}

	@Test
	void deveriaRetornarBonusDezPorcentoQuandoSalarioForExatamenteDezMil() {

		Funcionario funcionario = new Funcionario("FUNC_SALARIO_IGUAL_DEZ_MIL", LocalDate.now(),
				new BigDecimal(10000.00));
		BonusService bonusService = new BonusService();
		BigDecimal bonusCalculado = bonusService.calcularBonus(funcionario);

		BigDecimal bonusEsperado = new BigDecimal("1000.000").setScale(2, RoundingMode.HALF_UP);
		assertEquals(bonusEsperado, bonusCalculado, "Sal�rios de R$10000,00 recebem b�nus de 10%");
	}

	@Test
	void deveriaRetornarBonusDezPorcentoQuandoSalarioForMenorQueDezMil() {

		Funcionario funcionario = new Funcionario("FUNC_SALARIO_IGUAL_DEZ_MIL", LocalDate.now(),
				new BigDecimal(9999.99));
		BonusService bonusService = new BonusService();
		BigDecimal bonusCalculado = bonusService.calcularBonus(funcionario);

		BigDecimal bonusEsperado = new BigDecimal("999.999").setScale(2, RoundingMode.HALF_UP);
		assertEquals(bonusEsperado, bonusCalculado, "Sal�rios menores que R$10000,00 recebem b�nus de 10%");
	}

}
