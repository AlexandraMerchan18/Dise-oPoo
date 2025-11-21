package servicios; // paquete donde se encuentra esta clase

import dominio.Usuario; // importamos Usuario porque lo usamos en listas y métodos
import dominio.Puntuacion; // importamos Puntuacion para crear nuevas puntuaciones
import dominio.Juego; // importamos Juego para manejar juegos creados
import java.util.ArrayList; // importamos ArrayList para listas dinámicas
import java.util.List; // importamos List porque trabajamos con colecciones
import java.util.concurrent.atomic.AtomicInteger; // para generar ids automáticos y seguros

public class FachadaSistemaClasificacion implements Observer { // clase fachada que simplifica el uso del sistema y actúa como observador
    private List<Usuario> usuarios = new ArrayList<>(); // lista de usuarios registrados
    private List<Juego> juegos = new ArrayList<>(); // lista de juegos creados
    private EstrategiaClasificacion estrategia = new ClasificacionPorPuntos(); // estrategia por defecto para ordenar la clasificación
    private ServicioTiempoReal tiempoReal = new ServicioTiempoReal(); // servicio que maneja notificaciones en tiempo real
    private Leaderboard leaderboard; // leaderboard que se mostrará (decorado o no)
    private AtomicInteger nextUserId = new AtomicInteger(1); // contador automático para IDs de usuario
    private AtomicInteger nextScoreId = new AtomicInteger(1); // contador automático para IDs de puntuaciones
    private AtomicInteger nextGameId = new AtomicInteger(1); // contador automático para IDs de juegos

    public FachadaSistemaClasificacion(Leaderboard leaderboard) { // constructor que recibe el leaderboard inicial
        this.leaderboard = leaderboard; // guardamos el leaderboard
        tiempoReal.suscribir(this); // nos suscribimos al servicio de tiempo real como observadores
    }

    public Usuario registrarUsuario(String nombre, String email, String contraseña) { // registra un nuevo usuario
        Usuario u = new Usuario(nextUserId.getAndIncrement(), nombre, email, contraseña); // crea un nuevo usuario con id autoincrementado
        usuarios.add(u); // lo agrega a la lista
        actualizar(); // actualiza la clasificación
        return u; // retorna el usuario creado
    }

    public Juego crearJuego(String nombre, String descripcion) { // permite crear un nuevo juego
        Juego j = new Juego(nextGameId.getAndIncrement(), nombre, descripcion); // crea un nuevo juego con id automático
        juegos.add(j); // lo agrega a la lista de juegos
        return j; // retorna el juego creado
    }

    public void agregarPuntuacion(int usuarioId, int juegoId, int valor) { // agrega una puntuación a un usuario
        Usuario u = buscarUsuarioPorId(usuarioId); // busca el usuario por ID
        if (u == null) return; // si no existe, no hace nada
        Puntuacion p = new Puntuacion(nextScoreId.getAndIncrement(), usuarioId, juegoId, valor); // crea una nueva puntuación
        u.agregarPuntuacion(p); // agrega la puntuación al historial del usuario
        actualizar(); // actualiza la tabla de clasificación
    }

    private Usuario buscarUsuarioPorId(int id) { // método interno para buscar usuario por ID
        return usuarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null); // busca entre los registrados
    }

    public Usuario buscarUsuarioPorNombre(String nombre) { // busca usuario por nombre
        return usuarios.stream().filter(u -> u.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null); // retorna el primero que coincida
    }

    public void actualizar() { // actualiza la clasificación y notifica
        estrategia.ordenar(usuarios); // ordena según la estrategia actual
        leaderboard.mostrar(usuarios); // muestra la tabla usando el render configurado
        tiempoReal.notificar(); // envía notificación a observadores
    }

    public List<Usuario> getUsuarios() { return usuarios; } // retorna la lista de usuarios

    @Override
    public void update() { // reacción cuando el servicio de tiempo real notifica cambios
        System.out.println("[Fachada] Received update (observer) -> nothing heavy to do now"); // mensaje simple
    }
}

