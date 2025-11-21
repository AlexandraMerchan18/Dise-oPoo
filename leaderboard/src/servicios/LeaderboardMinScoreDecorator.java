package servicios;

import dominio.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardMinScoreDecorator implements Leaderboard {
    private Leaderboard inner;     // leaderboard original que se está decorando
    private int minScore;          // puntaje mínimo requerido

    public LeaderboardMinScoreDecorator(Leaderboard inner, int minScore) {
        this.inner = inner;        // guardamos el leaderboard base
        this.minScore = minScore;  // definimos el puntaje mínimo
    }

    @Override
    public void mostrar(List<Usuario> usuarios) {
        // filtramos solo usuarios que tengan un total >= minScore
        List<Usuario> filtered = usuarios.stream()
                .filter(u -> u.getTotalPuntos() >= minScore)
                .collect(Collectors.toList());

        inner.mostrar(filtered);   // mostramos usando el leaderboard original
    }
}
