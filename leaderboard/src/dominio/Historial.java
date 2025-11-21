package dominio; // paquete al que pertenece la clase

import java.util.ArrayList; // importa ArrayList
import java.util.List;      // importa List

public class Historial { // clase Historial: guarda las puntuaciones de un usuario
    private int usuarioId; // ID del usuario dueño del historial
    private List<Puntuacion> listaPuntuaciones = new ArrayList<>(); // lista donde se almacenan sus puntuaciones

    public Historial(int usuarioId) { // constructor que recibe el ID del usuario
        this.usuarioId = usuarioId;   // asigna el ID al atributo usuarioId
    }

    public void agregar(Puntuacion p) { // método para agregar una puntuación al historial
        listaPuntuaciones.add(p);       // agrega la puntuación a la lista
    }

    public List<Puntuacion> getLista() { return listaPuntuaciones; } // retorna la lista de puntuaciones

    public int getTotal() { // calcula el total sumando todas las puntuaciones
        return listaPuntuaciones        // toma la lista
                .stream()               // crea un stream para operar
                .mapToInt(Puntuacion::getValor) // extrae el valor de cada puntuación
                .sum();                 // suma todos los valores
    }
}
