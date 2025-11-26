package modelos;
public class Puntaje {
    private String jugador;
    private String juego;
    private double valor;
    public Puntaje(String jugador, String juego, double valor) { this.jugador = jugador; this.juego = juego; this.valor = valor; }
    public String getJugador() { return jugador; }
    public String getJuego() { return juego; }
    public double getValor() { return valor; }
}
