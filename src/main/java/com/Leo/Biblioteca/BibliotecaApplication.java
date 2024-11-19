package com.Leo.Biblioteca;

import com.Leo.Biblioteca.Principal.MenuPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
		System.out.println("¡Bienvenido a la Biblioteca!");

		// Llamar al menú principal
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.mostrarMenu();
	}
}
