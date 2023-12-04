package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Inventario;

@Repository
public class InventarioRepositoryImpl implements IInventarioRepository {

	private static List<Inventario> base = new ArrayList<Inventario>();

	@Override
	public Inventario seleccionar(String codigo) {
		// TODO Auto-generated method stub

		for (Inventario inventario : base) {
			if (inventario.getCodigo().equals(codigo)) {
				Inventario invt = new Inventario();
				invt.setFechaIngreso(inventario.getFechaIngreso());
				invt.setBodega(inventario.getBodega());
				invt.setProducto(inventario.getProducto());
				return invt;
			}
		}
		return null;
	}

	@Override
	public void insertar(Inventario inventario) {
		// TODO Auto-generated method stub
		base.add(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.eliminar(inventario.getCodigo());
		this.insertar(inventario);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Inventario inventario = this.seleccionar(codigo);
		base.remove(inventario);
	}
	
	//44444444444

}
