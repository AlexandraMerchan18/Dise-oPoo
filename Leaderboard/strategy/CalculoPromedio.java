package strategy;
import modelos.Puntaje;
import java.util.List;
public class CalculoPromedio implements CalculoStrategy {
    @Override
    public double calcularClasificacion(List<Puntaje> puntajes) { return puntajes.stream().mapToDouble(Puntaje::getValor).average().orElse(0); }
}
