package servicios;   // paquete donde vive esta clase

import dominio.Usuario;   // importamos la clase Usuario
import java.util.List;    // importamos List para manejar listas de usuarios

public class SimpleRender implements RenderStrategy {   // implementa la estrategia de renderizado simple
    @Override
    public void render(List<Usuario> usuarios) {        // método que muestra la tabla de forma simple
        System.out.println("--- Clasificación (Simple) ---");  // título del renderizado simple
        
        for (Usuario u : usuarios) {                    // recorre cada usuario de la lista
            System.out.println(u.getNombre() + " -> " + u.getTotalPuntos());   // imprime nombre y puntos totales
        }
    }
}

