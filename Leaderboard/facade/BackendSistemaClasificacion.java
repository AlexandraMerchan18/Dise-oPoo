package facade; // Paquete Facade
import servicios.*; // Importa servicios
import modelos.*; // Importa modelos
import observer.*; // Importa Observer
import strategy.*; // Importa Strategy
import java.util.*; // Utilidades

// Clase que implementa el patrón Facade: centraliza la lógica del sistema
public class BackendSistemaClasificacion {
    private ServicioJuegos servicioJuegos; // Servicio para juegos
    private ServicioUsuarios servicioUsuarios; // Servicio para usuarios
    private ServicioClasificacion servicioClasificacion; // Servicio para clasificación (Strategy)
    private ServicioNotificacion servicioNotificacion; // Servicio para notificaciones (Observer)
    private List<Puntaje> puntajes; // Lista de puntuaciones

    public BackendSistemaClasificacion() {
        servicioJuegos = new ServicioJuegos();
        servicioUsuarios = new ServicioUsuarios();
        servicioClasificacion = new ServicioClasificacion();
        servicioNotificacion = new ServicioNotificacion();
        puntajes = new ArrayList<>();
    }

    public void registrarUsuario(String nombre, String email) {
        Usuario u = new Usuario(nombre, email);
        servicioUsuarios.agregarUsuario(u);
        servicioNotificacion.notificar("Usuario registrado: " + nombre);
    }

    public void agregarJuego(String id, String nombre) {
        Juego j = new Juego(id, nombre);
        servicioJuegos.agregarJuego(j);
        System.out.println("Juego agregado: " + nombre);
    }

    public void agregarPuntaje(String jugador, String juego, double valor) {
        Puntaje p = new Puntaje(jugador, juego, valor);
        puntajes.add(p);
        System.out.println("Puntaje agregado: " + valor + " para jugador " + jugador + " en juego " + juego);
    }

    public void mostrarUsuarios() {
        for (Usuario u : servicioUsuarios.getUsuarios()) {
            System.out.println("Usuario: " + u.getNombre() + " - " + u.getEmail());
        }
    }

    public void mostrarPuntajes() {
        for (Puntaje p : puntajes) {
            System.out.println("Jugador: " + p.getJugador() + ", Juego: " + p.getJuego() + ", Puntuación: " + p.getValor());
        }
    }

    public void mostrarTablaPosiciones() {
        servicioClasificacion.setEstrategia(new CalculoPromedio());
        Map<String, Double> posiciones = servicioClasificacion.calcularTabla(puntajes);
        System.out.println("===== Tabla de Posiciones =====");
        posiciones.forEach((jugador, score) -> System.out.println(jugador + " -> " + score));
    }
}
