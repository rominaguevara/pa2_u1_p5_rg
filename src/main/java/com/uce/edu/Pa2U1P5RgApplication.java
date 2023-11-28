package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;
import com.uce.edu.trasnferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.trasnferencia.repository.modelo.Transferencia;

@SpringBootApplication
public class Pa2U1P5RgApplication implements CommandLineRunner {

	
	@Autowired
	private ITransferenciaService iTransferenciaService;

	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5RgApplication.class, args);
	}

	public void run(String... args) throws Exception {

		// 1.Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1750888404");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.iCuentaBancariaService.guardar(ctaOrigen);

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1719608729");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.iCuentaBancariaService.guardar(ctaDestino);

		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
		this.iTransferenciaService.realizar("5678", "1234", new BigDecimal(10));
		
		//Construir un reporte del estado de cuenta de todas las transferencias
		List<Transferencia> lista = this.iTransferenciaService.buscarTodos();
		int indice =0;
		for(Transferencia trans : lista) {
			indice++;
			System.out.println(indice + ":" + trans);		
		}	
		
		CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen1);

		CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("5678");
		System.out.println(ctaDestino1);
		
		
	}
}
