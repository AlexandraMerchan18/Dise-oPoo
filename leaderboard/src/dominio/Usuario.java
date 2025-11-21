package dominio; // paquete donde se encuentra la clase Usuario

import java.time.LocalDateTime; // permite manejar fecha y hora
import java.util.ArrayList;
import java.util.List;

public class Usuario { // clase que representa a un usuario del sistema
    private int id; // identificador único del usuario
    private String nombre; // nombre del usuario
    private String email; // correo electrónico del usuario
    private String contraseña; // contraseña del usuario
    private LocalDateTime fechaRegistro; // fecha en la que el usuario fue creado
    private Historial historial; // historial de puntuaciones del usuario

    public Usuario(int id, String nombre, String email, String contraseña) { // constructor que recibe los datos del usuario
        this.id = id; // asigna el id recibido al atributo id
        this.nombre = nombre; // asigna el nombre recibido
        this.email = email; // asigna el email recibido
        this.contraseña = contraseña; // asigna la contraseña recibida
        this.fechaRegistro = LocalDateTime.now(); // guarda la fecha actual como fecha de registro
        this.historial = new Historial(this.id); // crea un historial nuevo asociado al usuario
    }

    public int getId() { return id; } // retorna el id del usuario
    public String getNombre() { return nombre; } // retorna el nombre del usuario
    public String getEmail() { return email; } // retorna el email del usuario
    public LocalDateTime getFechaRegistro() { return fechaRegistro; } // retorna la fecha de registro del usuario

    public void agregarPuntuacion(Puntuacion p) { // método para agregar una puntuación al historial
        historial.agregar(p); // agrega la puntuación al historial interno
    }

    public int getTotalPuntos() { // obtiene el total sumado de todas las puntuaciones del usuario
        return historial.getTotal(); // devuelve el total calculado desde el historial
    }

    public Historial getHistorial() { return historial; } // retorna el historial completo del usuario

    @Override
    public String toString() { // devuelve una representación en texto del usuario
        return nombre + " (id=" + id + ") -> " + getTotalPuntos(); // muestra el nombre, id y total de puntos
    }
}

