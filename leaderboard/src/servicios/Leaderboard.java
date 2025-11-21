package servicios;

import dominio.Usuario;
import java.util.List;

public interface Leaderboard {

    void mostrar(List<Usuario> usuarios); // método que muestra la clasificación según la estrategia definida
}
