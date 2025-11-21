package servicios; // paquete donde está la clase

import dominio.Usuario; // importamos la clase Usuario para usarla en la lista
import java.util.List; // importamos List para manejar listas de usuarios
import java.util.Comparator; // importamos Comparator para ordenar

public class ClasificacionPorPuntos implements EstrategiaClasificacion { // clase que implementa la estrategia de ordenar por puntos

    @Override // indica que estamos sobrescribiendo el método de la interfaz
    public void ordenar(List<Usuario> usuarios) { // método que ordena la lista de usuarios
        usuarios.sort( // usamos sort para ordenar la lista directamente
                Comparator.comparingInt(Usuario::getTotalPuntos) // comparamos por la cantidad total de puntos
                        .reversed() // invertimos el orden para que el mayor puntaje quede primero
        );
    }
}
