package observer;
public class NotificadorEmail implements Notificador {
    @Override
    public void enviarNotificacion(String mensaje) { System.out.println("[Email] " + mensaje); }
}
