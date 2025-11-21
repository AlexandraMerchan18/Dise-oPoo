package servicios;

import dominio.Usuario;
import java.util.List;

public interface RenderStrategy {
    void render(List<Usuario> usuarios);   // define cómo debe mostrarse la lista de usuarios (tabla)
}
