package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.servicios.interfaces.IEmpresaServicio;
import apitiendavideo.apitiendavideo.entidades.Empresa;
import apitiendavideo.apitiendavideo.entidades.Titulo;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaControlador {

    private IEmpresaServicio servicio;

    public EmpresaControlador(IEmpresaServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Empresa> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empresa crear(@RequestBody Empresa Empresa) {
        Empresa.setId(0);
        return servicio.guardar(Empresa);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Empresa actualizar(@RequestBody Empresa Empresa) {
        if (servicio.obtener(Empresa.getId()) != null) {
            return servicio.guardar(Empresa);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{nombre}/buscartitulos", method = RequestMethod.GET)
    public List<Titulo> buscarTitulos(@PathVariable String nombre) {
        return servicio.buscarTitulos(nombre);
    }

}
