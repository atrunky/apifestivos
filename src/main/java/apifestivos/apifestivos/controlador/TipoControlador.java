package apifestivos.apifestivos.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.core.dominio.Tipo;
import apifestivos.apifestivos.core.interfaces.servicios.ITipoServicio;

@RestController
@RequestMapping("/tipo")
public class TipoControlador {
    
    private ITipoServicio servicio;

    public TipoControlador(ITipoServicio servicio) {
        this.servicio = servicio;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Tipo> listar(){
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Tipo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Tipo agregar(@RequestBody Tipo tipo) {
        return servicio.agregar(tipo);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Tipo modificar(@RequestBody Tipo tipo) {
        return servicio.modificar(tipo);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

}
