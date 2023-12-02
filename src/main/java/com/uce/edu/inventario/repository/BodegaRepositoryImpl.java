package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {

	private static List<Bodega> base = new ArrayList<Bodega>();

	@Override
	public Bodega seleccionar(String codigo) {
		// TODO Auto-generated method stub

		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(codigo)) {
				Bodega bodg = new Bodega();
				bodg.setNombre(bodega.getNombre());
				bodg.setDireccion(bodega.getDireccion());
				bodg.setCapacidad(bodega.getCapacidad());
				return bodg;
			}
		}
		return null;
	}

	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		base.add(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Bodega bodega = this.seleccionar(codigo);
		base.remove(bodega);
	}

}
