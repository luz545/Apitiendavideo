package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.servicios.interfaces.IRegionServicio;
import apitiendavideo.apitiendavideo.entidades.Region;
import apitiendavideo.apitiendavideo.repositorios.RegionRepositorio;

@Service
public class RegionServicio implements IRegionServicio {

    RegionRepositorio repositorio;

    public RegionServicio(RegionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Region> listar() {
        return repositorio.findAll();
    }

    @Override
    public Region obtener(Long id) {
        var region = repositorio.findById(id);
        return region.isEmpty() ? null : region.get();
    }

    @Override
    public List<Region> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Region guardar(Region region) {
        return repositorio.save(region);
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
