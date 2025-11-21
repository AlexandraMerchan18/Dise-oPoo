package dominio; // paquete donde está la clase

public class Juego { // clase que representa un juego del sistema
    private int id; // identificador único del juego
    private String nombre; // nombre del juego
    private String descripcion; // descripción del juego

    public Juego(int id, String nombre, String descripcion) { // constructor que recibe los datos del juego
        this.id = id; // asigna el id recibido al atributo id
        this.nombre = nombre; // asigna el nombre recibido al atributo nombre
        this.descripcion = descripcion; // asigna la descripción recibida al atributo descripcion
    }

    public int getId() { return id; } // retorna el id del juego
    public String getNombre() { return nombre; } // retorna el nombre del juego
    public String getDescripcion() { return descripcion; } // retorna la descripción del juego
}
