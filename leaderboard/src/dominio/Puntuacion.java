package dominio; // paquete donde se encuentra la clase

import java.time.LocalDateTime; // import para manejar fecha y hora

public class Puntuacion { // clase que representa una puntuación realizada por un usuario
    private int id; // identificador único de la puntuación
    private int usuarioId; // id del usuario que hizo la puntuación
    private int juegoId; // id del juego al que pertenece la puntuación
    private int valor; // valor numérico de los puntos obtenidos
    private LocalDateTime fecha; // fecha y hora en la que se registró la puntuación

    public Puntuacion(int id, int usuarioId, int juegoId, int valor) { // constructor que recibe los datos
        this.id = id; // asigna el id recibido al atributo id
        this.usuarioId = usuarioId; // asigna el id del usuario al atributo usuarioId
        this.juegoId = juegoId; // asigna el id del juego al atributo juegoId
        this.valor = valor; // asigna el valor de la puntuación al atributo valor
        this.fecha = LocalDateTime.now(); // guarda la fecha actual en el atributo fecha
    }

    public int getId() { return id; } // devuelve el id de la puntuación
    public int getUsuarioId() { return usuarioId; } // devuelve el id del usuario
    public int getJuegoId() { return juegoId; } // devuelve el id del juego
    public int getValor() { return valor; } // devuelve el valor de la puntuación
    public LocalDateTime getFecha() { return fecha; } // devuelve la fecha de creación

    @Override
    public String toString() { // método para mostrar la puntuación en formato texto
        return "Puntuacion{" + "usuarioId=" + usuarioId + ", juegoId=" + juegoId + ", valor=" + valor + ", fecha=" + fecha + '}'; // retorna el texto descriptivo
    }
}
