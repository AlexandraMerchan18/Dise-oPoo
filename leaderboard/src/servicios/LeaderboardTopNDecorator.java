package servicios;

import dominio.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardTopNDecorator implements Leaderboard {
    private Leaderboard inner;   // leaderboard original al que decoramos
    private int n;               // cantidad de usuarios a mostrar (top N)

    public LeaderboardTopNDecorator(Leaderboard inner, int n) {
        this.inner = inner;      // guardamos el leaderboard base
        this.n = n;              // guardamos el valor de N (cuántos mostrar)
    }

    @Override
    public void mostrar(List<Usuario> usuarios) {
        List<Usuario> top = usuarios.stream()  // convertimos la lista en stream
                .limit(n)                     // tomamos solo los primeros N usuarios
                .collect(Collectors.toList()); // regresamos a lista

        inner.mostrar(top);                   // mostramos solo los N filtrados usando el leaderboard original
    }
}

