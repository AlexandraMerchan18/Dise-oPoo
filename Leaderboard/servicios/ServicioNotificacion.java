package servicios;
import observer.*;
import java.util.*;
public class ServicioNotificacion {
    private List<Notificador> notificadores = new ArrayList<>();
    public ServicioNotificacion() {
        notificadores.add(new NotificadorEmail());
        notificadores.add(new NotificadorPush());
    }
    public void notificar(String mensaje) {
        for (Notificador n : notificadores) { n.enviarNotificacion(mensaje); }
    }
}
