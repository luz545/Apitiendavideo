package apitiendavideo.apitiendavideo.servicios.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Tecnologia;

public interface ITecnologiaServicio {
    
    public List<Tecnologia> listar();

    public Tecnologia obtener(Long id);

    public List<Tecnologia> buscar(String nombre);

    public Tecnologia guardar(Tecnologia tecnologia);

    public boolean eliminar(Long id);
}
