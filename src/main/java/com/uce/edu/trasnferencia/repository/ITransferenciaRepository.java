package com.uce.edu.trasnferencia.repository;

import com.uce.edu.trasnferencia.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	// CRUD
		public Transferencia seleccionar(String numero);

		public void insertar(Transferencia transferencia);

		public void actualizar(Transferencia transferencia);

		public void eliminar(String numero);
}
