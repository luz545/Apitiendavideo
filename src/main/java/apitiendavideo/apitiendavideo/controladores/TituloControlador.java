package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Titulo;
import apitiendavideo.apitiendavideo.servicios.interfaces.ITituloServicio;

@RestController
@RequestMapping("/api/titulos")
public class TituloControlador {
    
       private ITituloServicio servicio;

    public TituloControlador(ITituloServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Titulo> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Titulo obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Titulo> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Titulo crear(@RequestBody Titulo titulo) {
        titulo.setId(0);
        return servicio.guardar(titulo);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Titulo actualizar(@RequestBody Titulo titulo) {
        if (servicio.obtener(titulo.getId()) != null) {
            return servicio.guardar(titulo);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
}
