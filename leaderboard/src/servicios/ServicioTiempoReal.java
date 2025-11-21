package servicios;   // paquete donde vive este servicio

import java.util.ArrayList;   // lista dinámica
import java.util.List;        // interfaz List

public class ServicioTiempoReal {
    private List<Observer> observadores = new ArrayList<>();  // lista de observadores suscritos

    public void suscribir(Observer o) { observadores.add(o); }     // agrega un observador a la lista
    public void desuscribir(Observer o) { observadores.remove(o); } // elimina un observador de la lista

    public void notificar() {                        // método que avisa a todos los observadores
        System.out.println("[ServicioTiempoReal] Notificando observadores..."); // mensaje informativo
        for (Observer o : observadores) {            // recorre la lista de observadores
            o.update();                              // llama el método update() de cada observador
        }
    }
}

