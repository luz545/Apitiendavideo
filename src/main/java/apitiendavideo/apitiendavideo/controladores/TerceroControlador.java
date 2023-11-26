package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.servicios.interfaces.ITerceroServicio;
import apitiendavideo.apitiendavideo.entidades.Tercero;

@RestController
@RequestMapping("/api/terceros")
public class TerceroControlador {

    private ITerceroServicio servicio;

    public TerceroControlador(ITerceroServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Tercero> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Tercero obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Tercero> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Tercero crear(@RequestBody Tercero tercero) {
        tercero.setId(0);
        return servicio.guardar(tercero);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Tercero actualizar(@RequestBody Tercero tercero) {
        if (servicio.obtener(tercero.getId()) != null) {
            return servicio.guardar(tercero);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    } 
}
