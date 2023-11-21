package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;

@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{

	private static List<Materia> base = new ArrayList();
	
	
	@Override
	public Materia seleccionar(String codigo) {
		// TODO Auto-generated method stub
		System.out.println("Seleccionamos: "+codigo);
		
		for(Materia mate:base) {
			if(mate.getCodigo().equals(codigo)) {
				return mate;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		base.add(materia);
		System.out.println("Se insertó: "+materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.borrar(materia.getCodigo());
		this.insertar(materia);
		System.out.println("Se actualiza: "+materia);	
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		Materia mate = this.seleccionar(codigo);
		base.remove(mate);
		System.out.println("Se elimina: "+codigo);
	}

	@Override
	public List<Materia> seleccionarTodos() {
		// TODO Auto-generated method stub
		return base;
	}



	
}
