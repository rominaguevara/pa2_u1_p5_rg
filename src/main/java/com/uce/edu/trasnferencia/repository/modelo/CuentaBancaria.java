package com.uce.edu.trasnferencia.repository.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CuentaBancaria {
	private String numero;
	private String cedulaPropietario;
	private BigDecimal saldo;

	
	
	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", cedulaPropietario=" + cedulaPropietario + ", saldo=" + saldo
				+ "]";
	}

	// SET Y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}

