package apitiendavideo.apitiendavideo.servicios.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Ciudad;
import apitiendavideo.apitiendavideo.entidades.Tercero;

public interface ICiudadServicio {
    
    public List<Ciudad> listar();

    public Ciudad obtener(Long id);

    public List<Ciudad> buscar(String nombre);

    public List<Tercero> buscarClientes(String nombre);

    public Ciudad guardar(Ciudad pais);

    public boolean eliminar(Long id);
}
