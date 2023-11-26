package apitiendavideo.apitiendavideo.servicios.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Inventario;

public interface IInventarioServicio {
    
    public List<Inventario> listar();

    public Inventario obtener(Long id);

    public List<Inventario> buscar(String nombre);

    public Inventario guardar(Inventario inventario);

    public boolean eliminar(Long id);

}
