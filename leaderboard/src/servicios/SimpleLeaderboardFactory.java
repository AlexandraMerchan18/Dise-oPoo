package servicios;   // paquete donde se encuentra esta fábrica

public class SimpleLeaderboardFactory implements LeaderboardFactory {
    private RenderStrategy render;   // estrategia de renderizado que se usará para crear el leaderboard

    public SimpleLeaderboardFactory(RenderStrategy render) {
        this.render = render;        // guarda la estrategia enviada desde afuera
    }

    @Override
    public Leaderboard createLeaderboard() {
        return new LeaderboardSimple(render);   // crea y retorna un LeaderboardSimple usando la estrategia indicada
    }
}
