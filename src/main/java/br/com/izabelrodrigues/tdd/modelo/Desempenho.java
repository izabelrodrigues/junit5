/**
 *
 */
package br.com.izabelrodrigues.tdd.modelo;

import java.math.BigDecimal;

/**
 * @author Izabel Rodrigues
 *
 */
public enum Desempenho {

	A_DESEJAR(new BigDecimal("0.03")), //
	BOM(new BigDecimal("0.15")), //
	OTIMO(new BigDecimal("0.20"));

	private BigDecimal fatorReajuste;

	private Desempenho(BigDecimal fatorReajuste) {
		this.fatorReajuste = fatorReajuste;
	}

	/**
	 * @return the fatorReajuste
	 */
	public BigDecimal getFatorReajuste() {
		return fatorReajuste;
	}

}
