package com.uce.edu.trasnferencia.repository;

import java.util.List;

import com.uce.edu.trasnferencia.repository.modelo.Numeracion;

public interface INumeracionRepository {

	// CRUD

	public Numeracion seleccionar(long numero);

	public void insertar(Numeracion numeracionTransferencia);

	public void actualizar(Numeracion numeracionTransferencia);

	public void eliminar(long numero);

	public List<Numeracion> seleccionarTodo();

}
