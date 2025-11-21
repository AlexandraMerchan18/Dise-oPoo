package servicios; // paquete donde se encuentra la interfaz

public interface AbstractLeaderboardFactory { // interfaz que define una fábrica abstracta para crear leaderboards
    Leaderboard createBaseLeaderboard(); // método que crea un leaderboard base (sin decoradores)
    Leaderboard createTopNDecorated(int n); // método que crea un leaderboard decorado que muestra solo los primeros N
}
