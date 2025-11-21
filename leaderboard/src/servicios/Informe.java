package servicios;

import dominio.Usuario;
import java.util.List;

public class Informe {

    public void generarInforme(List<Usuario> usuarios, String periodo) {
        System.out.println("--- Informe del periodo: " + periodo + " ---"); // imprime encabezado del informe

        usuarios.forEach(u ->                                         // recorre todos los usuarios
            System.out.println(u.getNombre() + ": " + u.getTotalPuntos()) // imprime nombre y total de puntos
        );
    }
}


