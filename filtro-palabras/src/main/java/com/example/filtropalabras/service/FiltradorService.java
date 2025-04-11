package com.example.filtropalabras.service;

import com.example.filtropalabras.model.Mensaje;

public interface FiltradorService {

    /**
     * Procesa un mensaje y filtra las palabras prohibidas
     * @param mensaje El mensaje a procesar
     * @return El mensaje filtrado o un mensaje de advertencia
     */
    Mensaje procesarMensaje(Mensaje mensaje);
}