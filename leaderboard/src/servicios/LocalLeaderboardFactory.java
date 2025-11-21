package servicios;

public class LocalLeaderboardFactory implements AbstractLeaderboardFactory {
    private RenderStrategy render;                 // estrategia de renderizado que usará el leaderboard

    public LocalLeaderboardFactory(RenderStrategy render) {
        this.render = render;                      // guardamos la estrategia de render recibida
    }

    @Override
    public Leaderboard createBaseLeaderboard() {
        return new LeaderboardSimple(render);      // crea un leaderboard simple usando la estrategia de render
    }

    @Override
    public Leaderboard createTopNDecorated(int n) {
        return new LeaderboardTopNDecorator(       // crea un leaderboard decorado
                createBaseLeaderboard(),           // usa el leaderboard base
                n                                  // número de posiciones que se mostrarán (Top N)
        );
    }
}

