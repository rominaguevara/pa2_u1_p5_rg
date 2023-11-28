package com.uce.edu.trasnferencia.repository;

import com.uce.edu.trasnferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	// CRUD
	public CuentaBancaria selecionar(String nuemro);

	public void insertar(CuentaBancaria cuentaBancaria);

	public void actualizar(CuentaBancaria cuentaBancaria);

	public void eliminar(String numero);

}
