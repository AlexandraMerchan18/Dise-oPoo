package servicios;
import strategy.*;
import modelos.*;
import java.util.*;
public class ServicioClasificacion {
    private CalculoStrategy estrategia;
    public ServicioClasificacion() { this.estrategia = new CalculoPromedio(); }
    public void setEstrategia(CalculoStrategy estrategia) { this.estrategia = estrategia; }
    public Map<String, Double> calcularTabla(List<Puntaje> puntajes) {
        Map<String, List<Puntaje>> agrupado = new HashMap<>();
        for (Puntaje p : puntajes) { agrupado.computeIfAbsent(p.getJugador(), k -> new ArrayList<>()).add(p); }
        Map<String, Double> resultado = new HashMap<>();
        for (String jugador : agrupado.keySet()) { resultado.put(jugador, estrategia.calcularClasificacion(agrupado.get(jugador))); }
        return resultado;
    }
}
