package com.example.filtropalabras.aspect;

import com.example.filtropalabras.model.Mensaje;
import com.example.filtropalabras.service.FiltradorServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FiltradorAspect {

    private final FiltradorServiceImpl filtradorService;

    @Autowired
    public FiltradorAspect(FiltradorServiceImpl filtradorService) {
        this.filtradorService = filtradorService;
    }

    @Around("execution(* com.example.filtropalabras.service.FiltradorService.procesarMensaje(..)) && args(mensaje)")
    public Object filtrarMensajeAdvice(ProceedingJoinPoint joinPoint, Mensaje mensaje) throws Throwable {
        // Antes de ejecutar el método, filtramos el mensaje
        System.out.println("Interceptando mensaje: " + mensaje.getContenido());

        // Filtrar el mensaje usando el servicio
        Mensaje mensajeFiltrado = filtradorService.filtrarMensaje(mensaje);

        // Mostrar información sobre el filtrado
        if (mensajeFiltrado.isFiltrado()) {
            System.out.println("Se encontraron " + mensajeFiltrado.getPalabrasProhibidasEncontradas() +
                    " palabras prohibidas.");
        }

        // Continuamos con la ejecución del método original, pero pasando el mensaje ya filtrado
        Object[] args = new Object[] { mensajeFiltrado };
        return joinPoint.proceed(args);
    }
}