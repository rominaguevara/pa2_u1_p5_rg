package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.trasnferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.trasnferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
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
	public void depositar(String numeroCuenta, BigDecimal monto) {
		// TODO Auto-generated method stub 
				//1.-Buscar cuenta a la que se deposita
				CuentaBancaria cuenta = this.bancariaRepository.seleccionar(numeroCuenta);
				//2.-Consultar saldo cuenata a la que se deposita
				BigDecimal saldoCuenta = cuenta.getSaldo();
				//3.-Interes del banco(Si meto 100 solo recibiré 90 (10%))
				BigDecimal interes = new BigDecimal(0.10); //0.10
				BigDecimal tmp = monto.multiply(interes).setScale(2,RoundingMode.HALF_EVEN);  //10 (RoundingMode.HALF_EVEN para decir cuantos decimales quiero y redodear al mas cercano)
				BigDecimal nuevoMonto = monto.subtract(tmp); //100-10= 90
				//4.-Sumar monto restado lo del banco al saldo actual
				BigDecimal nuevoSaldoCuenta= saldoCuenta.add(nuevoMonto);
				//5.-Actualizar saldo y cuenta
				cuenta.setSaldo(nuevoSaldoCuenta);
				this.bancariaRepository.actualizar(cuenta);
				
				System.out.println("Deposito realizado con exito");
		}

}
