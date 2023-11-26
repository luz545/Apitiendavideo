package apitiendavideo.apitiendavideo.servicios.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Tercero;

public interface ITerceroServicio {
    
    public List<Tercero> listar();

    public Tercero obtener(Long id);

    public List<Tercero> buscar(String nombre);

    public Tercero guardar(Tercero tercero);

    public boolean eliminar(Long id);

}
