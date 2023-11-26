package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.servicios.interfaces.ICiudadServicio;
import apitiendavideo.apitiendavideo.entidades.Ciudad;
import apitiendavideo.apitiendavideo.entidades.Tercero;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadControlador {

    private ICiudadServicio servicio;

    public CiudadControlador(ICiudadServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Ciudad> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Ciudad obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Ciudad> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/{nombre}/buscarclientes", method = RequestMethod.GET)
    public List<Tercero> buscarClientes(@PathVariable String nombre) {
        return servicio.buscarClientes(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Ciudad crear(@RequestBody Ciudad ciudad) {
        return servicio.guardar(ciudad);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Ciudad actualizar(@RequestBody Ciudad ciudad) {
        return servicio.guardar(ciudad);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
    
}
