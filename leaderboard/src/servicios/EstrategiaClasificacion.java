package servicios; // paquete donde está definida esta interfaz

import dominio.Usuario; // importamos la clase Usuario para usarla en el método
import java.util.List; // importamos List para manejar colecciones de usuarios

public interface EstrategiaClasificacion { // interfaz que define una estrategia para ordenar usuarios
    void ordenar(List<Usuario> usuarios); // método que cada estrategia debe implementar para ordenar la lista
}
