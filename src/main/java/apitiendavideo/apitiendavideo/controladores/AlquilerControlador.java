package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Alquiler;
import apitiendavideo.apitiendavideo.servicios.interfaces.IAlquilerServicio;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerControlador {
    
        private IAlquilerServicio servicio;

    public AlquilerControlador(IAlquilerServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Alquiler> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Alquiler obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Alquiler crear(@RequestBody Alquiler alquiler) {
        alquiler.setId(0);
        return servicio.guardar(alquiler);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Alquiler actualizar(@RequestBody Alquiler alquiler) {
        if (servicio.obtener(alquiler.getId()) != null) {
            return servicio.guardar(alquiler);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
}
