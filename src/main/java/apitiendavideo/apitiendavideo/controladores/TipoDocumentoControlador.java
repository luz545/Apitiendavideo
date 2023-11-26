package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.TipoDocumento;
import apitiendavideo.apitiendavideo.servicios.interfaces.ITipoDocumentoServicio;

@RestController
@RequestMapping("/api/tiposdocumento")
public class TipoDocumentoControlador {
    
    private ITipoDocumentoServicio servicio;

    public TipoDocumentoControlador(ITipoDocumentoServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<TipoDocumento> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public TipoDocumento obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<TipoDocumento> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public TipoDocumento crear(@RequestBody TipoDocumento TipoDocumento) {
        TipoDocumento.setId(0);
        return servicio.guardar(TipoDocumento);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public TipoDocumento actualizar(@RequestBody TipoDocumento TipoDocumento) {
        if (servicio.obtener(TipoDocumento.getId()) != null) {
            return servicio.guardar(TipoDocumento);
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
