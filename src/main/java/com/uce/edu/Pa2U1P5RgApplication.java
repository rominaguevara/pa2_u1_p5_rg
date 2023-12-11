package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;


@SpringBootApplication
public class Pa2U1P5RgApplication implements CommandLineRunner {

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IInventarioService iInventarioService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IBodegaService bodegaService;

////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5RgApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		//1.-Crear dos productos "P1 y P2"
		Producto p1 = new Producto();
		p1.setCodigoBarras("123455");
		p1.setNombre("HP 15 laptop");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2 = new Producto();
		p2.setCodigoBarras("1597863");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		
		this.iProductoService.guardar(p2);
		
		//2.-Crear una bodega "B1" con capacidad cualquiera
		Bodega b1 = new Bodega();
		b1.setCodigo("123456789");
		b1.setNombre("BODEGA B1");
		b1.setDireccion("Sector Universidad Central");
		b1.setCapacidad(200);
		
		//3.-Registar Inventario
		  //50 unidades P1 en B1
		this.iInventarioService.registar("123456789", "123455", 50);
		  //100 unidades P2 en B1
		this.iInventarioService.registar("123456789", "1597863", 100);
		  //20 unidades P1 en B1
		this.iInventarioService.registar("123456789", "123455", 20);
		
		//4.-Buscar producto P1 y P2 y se imprime
		this.productoService.buscar("123455");
		System.out.println(p1);
		
		this.productoService.buscar("1597863");
		System.out.println(p2);
		
		//11/12/2023
		//11/12/2023
		
		
		
	}
}
