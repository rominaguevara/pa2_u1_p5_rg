package com.uce.edu.trasnferencia.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Transferencia {

	private String numero;
	private LocalDateTime fecha;
	private BigDecimal monto;
	private CuentaBancaria cuentaOrigen;
	private CuentaBancaria cuentaDestino;

	@Override
	public String toString() {
		return "Transferencia [numero=" + numero + ", fecha=" + fecha + ", monto=" + monto + ", cuentaOrigen="
				+ cuentaOrigen + ", cuentaDestino=" + cuentaDestino + "]";
	}

	
	// SET Y GET


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime localDateTime) {
		this.fecha = localDateTime;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

}

