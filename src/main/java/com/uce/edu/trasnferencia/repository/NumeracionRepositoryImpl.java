package com.uce.edu.trasnferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.trasnferencia.repository.modelo.Numeracion;

@Repository
public class NumeracionRepositoryImpl implements INumeracionRepository{


	private static List<Numeracion> base = new ArrayList<Numeracion>();

	@Override
	public Numeracion seleccionar(long numero) {
		// TODO Auto-generated method stub
		for(Numeracion contador:base) {
			if(contador.getContador()==numero) {
				return contador;
			}
		}

		return null;
	}

	@Override
	public void insertar(Numeracion numeracionTransferencia) {
		// TODO Auto-generated method stub
		base.add(numeracionTransferencia);
	}

	@Override
	public void actualizar(Numeracion numeracionTransferencia) {
		// TODO Auto-generated method stub
		this.eliminar(numeracionTransferencia.getContador());
		this.insertar(numeracionTransferencia);

	}

	@Override
	public void eliminar(long numero) {
		// TODO Auto-generated method stub
		Numeracion contador = this.seleccionar(numero);
		base.remove(contador);
	}

	@Override
	public List<Numeracion> seleccionarTodo() {
		// TODO Auto-generated method stub
		return base;
	}

}