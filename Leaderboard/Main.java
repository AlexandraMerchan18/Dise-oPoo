import facade.BackendSistemaClasificacion;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BackendSistemaClasificacion backend = new BackendSistemaClasificacion();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Mostrar tabla de posiciones");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Agregar juego");
            System.out.println("4. Agregar puntuación");
            System.out.println("5. Mostrar usuarios");
            System.out.println("6. Mostrar puntuaciones");
            System.out.println("0. Salir");
            opcion = sc.nextInt(); sc.nextLine();
            switch(opcion) {
                case 1: backend.mostrarTablaPosiciones(); break;
                case 2:
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    backend.registrarUsuario(nombre, email); break;
                case 3:
                    System.out.print("ID juego: "); String idJuego = sc.nextLine();
                    System.out.print("Nombre juego: "); String nombreJuego = sc.nextLine();
                    backend.agregarJuego(idJuego, nombreJuego); break;
                case 4:
                    System.out.print("Jugador: "); String jugador = sc.nextLine();
                    System.out.print("Juego: "); String juego = sc.nextLine();
                    System.out.print("Puntuación: "); double puntaje = sc.nextDouble(); sc.nextLine();
                    backend.agregarPuntaje(jugador, juego, puntaje); break;
                case 5: backend.mostrarUsuarios(); break;
                case 6: backend.mostrarPuntajes(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while(opcion != 0);
        sc.close();
    }
}
