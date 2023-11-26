package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.servicios.interfaces.ITerceroServicio;
import apitiendavideo.apitiendavideo.entidades.Tercero;
import apitiendavideo.apitiendavideo.repositorios.TerceroRepositorio;

@Service
public class TerceroServicio implements ITerceroServicio {

    private TerceroRepositorio repositorio;

    public TerceroServicio(TerceroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Tercero> listar() {
        return repositorio.findAll();
    }

    @Override
    public Tercero obtener(Long id) {
        var tercero = repositorio.findById(id);
        return tercero.isEmpty() ? null : tercero.get();
    }

    @Override
    public List<Tercero> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Tercero guardar(Tercero tercero) {
        return repositorio.save(tercero);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
