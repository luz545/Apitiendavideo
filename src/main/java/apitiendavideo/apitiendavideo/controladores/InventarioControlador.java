package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Inventario;
import apitiendavideo.apitiendavideo.servicios.interfaces.IInventarioServicio;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioControlador {
    
        
       private IInventarioServicio servicio;

    public InventarioControlador(IInventarioServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Inventario> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Inventario obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Inventario> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Inventario crear(@RequestBody Inventario inventario) {
        inventario.setId(0);
        return servicio.guardar(inventario);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Inventario actualizar(@RequestBody Inventario inventario) {
        if (servicio.obtener(inventario.getId()) != null) {
            return servicio.guardar(inventario);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

}
