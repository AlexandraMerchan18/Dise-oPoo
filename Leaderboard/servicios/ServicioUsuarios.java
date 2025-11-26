package servicios;
import modelos.Usuario;
import java.util.*;
public class ServicioUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();
    public void agregarUsuario(Usuario u) { usuarios.add(u); }
    public List<Usuario> getUsuarios() { return usuarios; }
}
