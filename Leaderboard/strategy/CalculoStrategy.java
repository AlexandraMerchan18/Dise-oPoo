package strategy;
import modelos.Puntaje;
import java.util.List;
public interface CalculoStrategy { double calcularClasificacion(List<Puntaje> puntajes); }
