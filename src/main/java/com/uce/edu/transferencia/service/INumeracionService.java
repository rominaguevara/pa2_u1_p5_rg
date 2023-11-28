package com.uce.edu.transferencia.service;

import java.util.List;

import com.uce.edu.trasnferencia.repository.modelo.Numeracion;

public interface INumeracionService {
	
	// CRUD
		public Numeracion seleccionar(long numero);

		public void insertar(Numeracion numeracion);

		public void actualizar(Numeracion numeracion);

		public void eliminar(long numero);

		public String contar();

		public List<Numeracion> seleccionarTodo();

}
