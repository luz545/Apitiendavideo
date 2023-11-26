package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Region;
import apitiendavideo.apitiendavideo.servicios.interfaces.IRegionServicio;

@RestController
@RequestMapping("/api/regiones")
public class RegionControlador {
    private IRegionServicio servicio;

    public RegionControlador(IRegionServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Region> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Region obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Region> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Region crear(@RequestBody Region region) {
        region.setId(0);
        return servicio.guardar(region);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Region actualizar(@RequestBody Region region) {
        if (servicio.obtener(region.getId()) != null) {
            return servicio.guardar(region);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
}
