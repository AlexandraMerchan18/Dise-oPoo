package servicios;
import modelos.Juego;
import java.util.*;
public class ServicioJuegos {
    private List<Juego> juegos = new ArrayList<>();
    public void agregarJuego(Juego j) { juegos.add(j); }
    public List<Juego> getJuegos() { return juegos; }
}
