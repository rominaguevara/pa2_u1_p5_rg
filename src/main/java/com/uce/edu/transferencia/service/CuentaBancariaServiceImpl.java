package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.trasnferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.trasnferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.trasnferencia.repository.modelo.Transferencia;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	private ICuentaBancariaService bancariaService;
	
	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(numero);
	}

	@Override
	public void depositar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
				//-------------------------------------------------------------
				//-------------------------------------------------------------
				// 6. Buscar Cta Destino
				CuentaBancaria ctaDestino = this.bancariaService.buscar(numeroDestino);
				System.out.println(ctaDestino.hashCode());
				// 7. Consultar saldo
				BigDecimal saldoDestino = ctaDestino.getSaldo();
				// 8. Sumar el monto
				BigDecimal nuevoSaldoDestino= saldoDestino.add(monto);
				// 9. Actualizar cta destino
				ctaDestino.setSaldo(nuevoSaldoDestino);
				this.bancariaService.actualizar(ctaDestino);
				// 10. Crear la transferencia
				Transferencia transferencia = new Transferencia();
				transferencia.setCuentaDestino(ctaDestino);
				transferencia.setFecha(LocalDateTime.now());
				transferencia.setMonto(monto);
				transferencia.setNumero("123123123");
				
				this.bancariaService.guardar(ctaDestino);
				System.out.println("Transferencia realizada con Exito!");		
		
	}

}
