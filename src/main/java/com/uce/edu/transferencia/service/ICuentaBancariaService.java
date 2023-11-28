package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import com.uce.edu.trasnferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	// CRUD
	public CuentaBancaria buscar(String numero);

	public void guardar(CuentaBancaria cuentaBancaria);

	public void actualizar(CuentaBancaria cuentaBancaria);

	public void eliminar(String numero);
	
	public void depositar(String numeroOrigen, String numeroDestino, BigDecimal monto);
}
