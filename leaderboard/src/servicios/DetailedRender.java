package servicios; // paquete donde está esta clase

import dominio.Usuario; // importamos Usuario para usarlo en la lista
import java.util.List; // importamos List para manejar colecciones de usuarios

public class DetailedRender implements RenderStrategy { // clase que implementa la estrategia de renderizado detallado

    @Override // indica que estamos sobrescribiendo el método render de la interfaz
    public void render(List<Usuario> usuarios) { // método que recibe la lista de usuarios para mostrar en pantalla
        System.out.println("--- Clasificación (Detallada) ---"); // imprime el título de la tabla detallada

        for (Usuario u : usuarios) { // recorremos cada usuario de la lista
            System.out.println(u); // imprimimos el usuario (muestra nombre y puntos totales por el toString)

            u.getHistorial().getLista().forEach(p -> // obtenemos su historial y recorremos cada puntuación
                System.out.println("   " + p) // imprimimos cada puntuación con un espacio para que se vea como detalle
            );
        }
    }
}

