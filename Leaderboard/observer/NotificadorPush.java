package observer;
public class NotificadorPush implements Notificador {
    @Override
    public void enviarNotificacion(String mensaje) { System.out.println("[Push] " + mensaje); }
}
