package app; // indica que esta clase pertenece al paquete 'app'

import servicios.*; // importa todas las clases dentro del paquete servicios
import dominio.*; // importa todas las clases del paquete dominio
import java.util.Scanner; // importa Scanner para leer datos por consola

public class Main { // clase principal del programa
    public static void main(String[] args) { // método principal donde arranca la aplicación

        RenderStrategy simpleRender = new SimpleRender(); // crea una estrategia de render simple (Strategy)
        AbstractLeaderboardFactory factory = new LocalLeaderboardFactory(simpleRender); // crea una fábrica que construye el leaderboard (Abstract Factory)
        Leaderboard base = factory.createBaseLeaderboard(); // crea una instancia base del leaderboard mediante Factory Method

        Leaderboard decorated = 
            new LeaderboardTopNDecorator(                 // decora el leaderboard para mostrar solo top N
                new LeaderboardMinScoreDecorator(base, 0), // decora antes para filtrar por puntaje mínimo (0)
            10);                                           // solo mostrará los primeros 10

        FachadaSistemaClasificacion fachada = 
            new FachadaSistemaClasificacion(decorated); // fachada que unifica todas las operaciones del sistema

        Juego juego1 = fachada.crearJuego("Space Invaders", "Shooter retro"); // crea el juego 1
        Juego juego2 = fachada.crearJuego("Runner", "Endless runner"); // crea el juego 2

        Scanner sc = new Scanner(System.in); // lector de entrada
        int opcion = -1; // variable para controlar el menú

        while(opcion != 6) { // ciclo hasta que el usuario seleccione salir
            System.out.println("\n--- MENÚ ---"); // imprime menú
            System.out.println("1. Registrar usuario"); // opción 1
            System.out.println("2. Agregar puntuación"); // opción 2
            System.out.println("3. Ver tabla"); // opción 3
            System.out.println("4. Generar informe"); // opción 4
            System.out.println("5. Cambiar render (Strategy)"); // opción 5
            System.out.println("6. Salir"); // opción 6
            System.out.print("Seleccione una opción: "); // pide entrada
            opcion = Integer.parseInt(sc.nextLine()); // lee la opción del usuario

            switch(opcion) { // selecciona la acción correspondiente
                case 1: // registrar usuario
                    System.out.print("Nombre: "); // pide nombre
                    String nombre = sc.nextLine(); // lee nombre
                    System.out.print("Email: "); // pide email
                    String email = sc.nextLine(); // lee email
                    System.out.print("Contraseña: "); // pide contraseña
                    String contra = sc.nextLine(); // lee contraseña
                    fachada.registrarUsuario(nombre, email, contra); // registra el usuario en el sistema
                    break;

                case 2: // agregar puntuación
                    System.out.print("Nombre de usuario: "); // pide nombre del usuario
                    String uname = sc.nextLine(); // lee nombre
                    Usuario u = fachada.buscarUsuarioPorNombre(uname); // busca usuario por nombre
                    if (u == null) { // si no existe
                        System.out.println("Usuario no encontrado"); // muestra error
                        break; // sale del caso
                    }
                    System.out.print("Id de juego (1 o 2): "); // pide id del juego
                    int gid = Integer.parseInt(sc.nextLine()); // lee id de juego
                    System.out.print("Puntos: "); // pide puntos
                    int pts = Integer.parseInt(sc.nextLine()); // lee puntaje
                    fachada.agregarPuntuacion(u.getId(), gid, pts); // agrega la puntuación al usuario
                    break;

                case 3: // mostrar tabla
                    fachada.actualizar(); // actualiza y muestra la tabla de clasificación
                    break;

                case 4: // generar informe
                    Informe informe = new Informe(); // crea un informe
                    informe.generarInforme(fachada.getUsuarios(), "hoy"); // genera el informe basado en los usuarios
                    break;

                case 5: // cambiar render
                    System.out.println("1: Simple, 2: Detallada"); // muestra opciones
                    int r = Integer.parseInt(sc.nextLine()); // lee la opción
                    if (r == 1) { // si escoge render simple
                        System.out.println("Cambiando a SimpleRender..."); // mensaje
                        AbstractLeaderboardFactory f2 = 
                            new LocalLeaderboardFactory(new SimpleRender()); // nueva fábrica con render simple

                        fachada = new FachadaSistemaClasificacion( // nueva fachada con leaderboard decorado
                            new LeaderboardTopNDecorator(
                                new LeaderboardMinScoreDecorator(f2.createBaseLeaderboard(), 0),
                                10
                            )
                        );
                    } else { // si escoge render detallado
                        System.out.println("Cambiando a DetailedRender..."); // mensaje
                        AbstractLeaderboardFactory f2 = 
                            new LocalLeaderboardFactory(new DetailedRender()); // fábrica con render detallado

                        fachada = new FachadaSistemaClasificacion( // nueva fachada
                            new LeaderboardTopNDecorator(
                                new LeaderboardMinScoreDecorator(f2.createBaseLeaderboard(), 0),
                                10
                            )
                        );
                    }
                    break;

                case 6: // salir
                    System.out.println("Saliendo..."); // mensaje de salida
                    break;

                default: // opción inválida
                    System.out.println("Opción inválida"); // mensaje de error
            }
        }

        sc.close(); // cierra el scanner
    }
}

