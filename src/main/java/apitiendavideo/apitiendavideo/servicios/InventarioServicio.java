package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.servicios.interfaces.IInventarioServicio;
import apitiendavideo.apitiendavideo.entidades.Inventario;
import apitiendavideo.apitiendavideo.repositorios.InventarioRepositorio;

@Service
public class InventarioServicio implements IInventarioServicio {

    InventarioRepositorio repositorio;

    public InventarioServicio(InventarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Inventario> listar() {
        return repositorio.findAll();
    }

    @Override
    public Inventario obtener(Long id) {
        var pais = repositorio.findById(id);
        return pais.isEmpty() ? null : pais.get();
    }

    @Override
    public List<Inventario> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Inventario guardar(Inventario pais) {
        return repositorio.save(pais);
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
