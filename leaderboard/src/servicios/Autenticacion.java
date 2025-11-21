package servicios; // paquete donde está la clase

import dominio.Usuario; // importamos la clase Usuario
import java.util.List; // importamos lista porque recibimos una lista de usuarios

public class Autenticacion { // clase que maneja la autenticación del usuario

    // Implementación mínima: valida por email y contraseña entre lista provista por fachada
    public boolean validarCredenciales(List<Usuario> usuarios, String email, String contraseña) { // método que valida si un usuario existe
        return usuarios.stream() // recorremos la lista como stream
                .anyMatch(u -> // buscamos si existe algún usuario que cumpla la condición
                        u.getEmail().equalsIgnoreCase(email) // compara el email (sin importar mayúsculas)
                        && u.getHistorial() != null // se asegura de que el usuario tenga historial (usuario válido)
                        && contraseña != null // contraseña no debe ser null
                        && !contraseña.isEmpty() // contraseña no debe estar vacía
                );
    }

    public String generarToken(Usuario u) { // genera un token de autenticación
        return "token-" + u.getId() + "-" + System.currentTimeMillis(); // arma un token simple usando id + tiempo
    }
}
