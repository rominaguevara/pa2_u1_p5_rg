package com.uce.edu.trasnferencia.repository;

import java.util.List;

import com.uce.edu.trasnferencia.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	// CRUD
	public Transferencia selecionar(String nuemro);

	public void insertar(Transferencia transferencia);

	public void actualizar(Transferencia transferencia);

	public void eliminar(String numero);

	public List<Transferencia> selecionarTodo();

	Transferencia seleccionar(String numero);
}
