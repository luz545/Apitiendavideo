package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.servicios.interfaces.ITipoDocumentoServicio;
import apitiendavideo.apitiendavideo.entidades.TipoDocumento;
import apitiendavideo.apitiendavideo.repositorios.TipoDocumentoRepositorio;

 @Service
public class TipoDocumentoServicio implements ITipoDocumentoServicio {

    private TipoDocumentoRepositorio repositorio;

    public TipoDocumentoServicio(TipoDocumentoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<TipoDocumento> listar() {
        return repositorio.findAll();
    }

    @Override
    public TipoDocumento obtener(Long id) {
        var tipoDocumento = repositorio.findById(id);
        return tipoDocumento.isEmpty() ? null : tipoDocumento.get();
    }

    @Override
    public List<TipoDocumento> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public TipoDocumento guardar(TipoDocumento tipoDocumento) {
        return repositorio.save(tipoDocumento);
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
