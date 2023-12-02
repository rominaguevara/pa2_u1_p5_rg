package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

public interface IBodegaRepository {

	// CRUD
	public Bodega seleccionar(String codigo);

	public void insertar(Bodega bodega);

	public void actualizar(Bodega bodega);

	public void eliminar(String codigo);
}
