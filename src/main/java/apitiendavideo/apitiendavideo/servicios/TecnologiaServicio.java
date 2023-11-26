package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.servicios.interfaces.ITecnologiaServicio;
import apitiendavideo.apitiendavideo.entidades.Tecnologia;
import apitiendavideo.apitiendavideo.repositorios.TecnologiaRepositorio;

 @Service
public class TecnologiaServicio implements ITecnologiaServicio {

    private TecnologiaRepositorio repositorio;

    public TecnologiaServicio(TecnologiaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Tecnologia> listar() {
        return repositorio.findAll();
    }

    @Override
    public Tecnologia obtener(Long id) {
        var tecnologia = repositorio.findById(id);
        return tecnologia.isEmpty() ? null : tecnologia.get();
    }

    @Override
    public List<Tecnologia> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Tecnologia guardar(Tecnologia tecnologia) {
        return repositorio.save(tecnologia);
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
