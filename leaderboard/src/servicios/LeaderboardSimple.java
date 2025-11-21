package servicios;

import dominio.Usuario;
import java.util.List;

public class LeaderboardSimple implements Leaderboard {
    private RenderStrategy renderStrategy;   // estrategia que define cómo se mostrará la tabla

    public LeaderboardSimple(RenderStrategy renderStrategy) {
        this.renderStrategy = renderStrategy; // guardamos la estrategia elegida (simple, detallada, etc.)
    }

    @Override
    public void mostrar(List<Usuario> usuarios) {
        renderStrategy.render(usuarios);      // delega la visualización a la estrategia
    }
}
