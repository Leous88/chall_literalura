package com.Leo.Biblioteca.Principal;

import java.util.Scanner;

public class MenuPrincipal {
    private final LibroService libroService = new LibroService();

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    buscarLibro(scanner);
                    break;
                case 2:
                    listarLibros();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void buscarLibro(Scanner scanner) {
        System.out.print("Ingresa el título del libro: ");
        scanner.nextLine(); // Limpiar buffer
        String titulo = scanner.nextLine();

        Libro libro = libroService.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }

    private void listarLibros() {
        System.out.println("Lista de libros:");
        for (Libro libro : libroService.listarTodosLosLibros()) {
            System.out.println(libro);
        }
    }
}
