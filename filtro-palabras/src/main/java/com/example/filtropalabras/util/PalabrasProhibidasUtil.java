package com.example.filtropalabras.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class PalabrasProhibidasUtil {

    private final Set<String> palabrasProhibidas;
    private final String sustitucion = "!#?%@";

    public PalabrasProhibidasUtil() {
        // Lista de palabras prohibidas
        palabrasProhibidas = new HashSet<>(Arrays.asList(
                "naco",
                "huevarturo",
                "huevarceo",
                "huevon",
                "huevonc",
                "huevonso",
                "infiel",
                "infielonso",
                "pene",
                "gorda",
                "gordas",
                "perdedor",
                "UL",
                "Uriel",
                "yael",
                "ake",
                "tonto",
                "idiota",
                "estupido",
                "pendejo",
                "baboso"
        ));
    }

    public Set<String> getPalabrasProhibidas() {
        return palabrasProhibidas;
    }

    public String getSustitucion() {
        return sustitucion;
    }

    public boolean esPalabraProhibida(String palabra) {
        return palabrasProhibidas.contains(palabra.toLowerCase());
    }
}