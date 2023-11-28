package com.uce.edu.transferencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uce.edu.trasnferencia.repository.INumeracionRepository;
import com.uce.edu.trasnferencia.repository.modelo.Numeracion;

@Service
public class NumeracionServiceImpl implements INumeracionService {

	@Autowired
	private INumeracionRepository numeracionRepository;

	@Override
	public Numeracion seleccionar(long numero) {
		// TODO Auto-generated method stub
		return this.numeracionRepository.seleccionar(numero);
	}

	@Override
	public void insertar(Numeracion numeracionTransferencia) {
		// TODO Auto-generated method stub
		this.numeracionRepository.insertar(numeracionTransferencia);
	}

	@Override
	public void actualizar(Numeracion numeracionTransferencia) {
		// TODO Auto-generated method stub
		this.numeracionRepository.actualizar(numeracionTransferencia);
	}

	@Override
	public void eliminar(long numero) {
		// TODO Auto-generated method stub
		this.numeracionRepository.eliminar(numero);
	}

	@Override
	public String contar() {
		long temp =0;
		List<Numeracion> listtemp = this.seleccionarTodo();
		if(listtemp.isEmpty()) {
			Numeracion contadortemp = new Numeracion();
			contadortemp.setContador(1);
			this.numeracionRepository.insertar(contadortemp);
			return String.valueOf(1);
		}else {
			Numeracion numa = listtemp.get(listtemp.size()-1);
			temp = numa.getContador();
			Numeracion num = new Numeracion();
			num.setContador(temp+1);
			this.numeracionRepository.insertar(num);
			return String.valueOf(temp+1);
		}

	}

	@Override
	public List<Numeracion> seleccionarTodo() {
		// TODO Auto-generated method stub
		return numeracionRepository.seleccionarTodo();
	}

}