package com.example.filtropalabras.service;

import com.example.filtropalabras.model.Mensaje;
import com.example.filtropalabras.util.PalabrasProhibidasUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FiltradorServiceImpl implements FiltradorService {

    private final PalabrasProhibidasUtil palabrasProhibidasUtil;

    @Autowired
    public FiltradorServiceImpl(PalabrasProhibidasUtil palabrasProhibidasUtil) {
        this.palabrasProhibidasUtil = palabrasProhibidasUtil;
    }

    @Override
    public Mensaje procesarMensaje(Mensaje mensaje) {
        // Esta función será interceptada por el aspecto

        return mensaje;
    }

    // Este método será llamado desde el aspecto
    public Mensaje filtrarMensaje(Mensaje mensaje) {
        String contenido = mensaje.getContenido();
        int contadorPalabrasProhibidas = 0;

        // Crear un patrón para buscar palabras completas
        StringBuilder patternBuilder = new StringBuilder("\\b(");
        boolean first = true;

        for (String palabra : palabrasProhibidasUtil.getPalabrasProhibidas()) {
            if (!first) {
                patternBuilder.append("|");
            }
            patternBuilder.append(Pattern.quote(palabra));
            first = false;
        }
        patternBuilder.append(")\\b");

        Pattern pattern = Pattern.compile(patternBuilder.toString(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(contenido);

        StringBuffer resultBuffer = new StringBuffer();

        while (matcher.find()) {
            contadorPalabrasProhibidas++;
            matcher.appendReplacement(resultBuffer, palabrasProhibidasUtil.getSustitucion());
        }
        matcher.appendTail(resultBuffer);

        mensaje.setPalabrasProhibidasEncontradas(contadorPalabrasProhibidas);

        if (contadorPalabrasProhibidas > 3) {
            mensaje.setContenido("MENSAJE BLOQUEADO: Contiene demasiadas palabras inapropiadas.");
        } else {
            mensaje.setContenido(resultBuffer.toString());
        }

        mensaje.setFiltrado(contadorPalabrasProhibidas > 0);

        return mensaje;
    }
}