package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import com.uce.edu.trasnferencia.repository.modelo.Transferencia;


public interface ITransferenciaService {
	// CRUD
		public Transferencia buscar(String numero);

		public void guardar(Transferencia transferencia);

		public void actualizar(Transferencia transferencia);

		public void eliminar(String numero);
		
		public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto);
}
