package com.example.filtropalabras.ui;

import com.example.filtropalabras.model.Mensaje;
import com.example.filtropalabras.service.FiltradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsolaUI implements CommandLineRunner {

    private final FiltradorService filtradorService;
    private final Scanner scanner;

    @Autowired
    public ConsolaUI(FiltradorService filtradorService) {
        this.filtradorService = filtradorService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) {
        System.out.println("Sistema de filtros Laíncs");
        System.out.println("Escriba su mensaje o  escribe la palabra 'iguana' para salir    :");

        String entrada = "";
        while (true) {
            System.out.print("> ");
            entrada = scanner.nextLine();

            if ("iguana".equalsIgnoreCase(entrada)) {
                break;
            }

            Mensaje mensaje = new Mensaje(entrada);
            Mensaje mensajeFiltrado = filtradorService.procesarMensaje(mensaje);

            System.out.println("Mensaje procesado: " + mensajeFiltrado.getContenido());
        }

        System.out.println("Poke adiós");
    }
}