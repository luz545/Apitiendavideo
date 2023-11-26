package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Tecnologia;
import apitiendavideo.apitiendavideo.servicios.interfaces.ITecnologiaServicio;

@RestController
@RequestMapping("/api/tecnologias")
public class TecnologiaControlador {

    private ITecnologiaServicio servicio;

    public TecnologiaControlador(ITecnologiaServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Tecnologia> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Tecnologia obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Tecnologia> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Tecnologia crear(@RequestBody Tecnologia Tecnologia) {
        Tecnologia.setId(0);
        return servicio.guardar(Tecnologia);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Tecnologia actualizar(@RequestBody Tecnologia Tecnologia) {
        if (servicio.obtener(Tecnologia.getId()) != null) {
            return servicio.guardar(Tecnologia);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
}
