package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.trasnferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.trasnferencia.repository.ITransferenciaRepository;
import com.uce.edu.trasnferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.trasnferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// 1. Buscar cuenta de origen
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.seleccionar(numeroOrigen);
		// 2. Consultar el saldo
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		// 3. Validar el saldo
		if(saldoOrigen.compareTo(monto)>=0) {
		// 4. Restar el monto
		BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
		// 5. Actualizar el monto
		ctaOrigen.setSaldo(nuevoSaldoOrigen);
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		// 6. Buscar Cta Destino
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.seleccionar(numeroDestino);	
		// 7. Consultar saldo
		BigDecimal saldoDestino = ctaDestino.getSaldo();
		// 8. Sumar el monto
		BigDecimal nuevoSaldoDestino= saldoDestino.add(monto);
		// 9. Actualizar cta destino
		ctaDestino.setSaldo(nuevoSaldoDestino);
		this.iCuentaBancariaRepository.actualizar(ctaDestino);
		// 10. Crear la transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaOrigen(ctaOrigen);
		transferencia.setCuentaDestino(ctaDestino);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		transferencia.setNumero("123123123");
		
		this.iTransferenciaRepository.insertar(transferencia);
		System.out.println("Transferencia realizada con Exito!");
		
		}else {
			System.out.println("Saldo no disponible");
		}
	
	}

}
