package apifestivos.apifestivos.aplicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import apifestivos.apifestivos.core.dominio.Tipo;
import apifestivos.apifestivos.core.interfaces.repositorios.ITipoRepositorio;
import apifestivos.apifestivos.core.interfaces.servicios.ITipoServicio;

@Service
public class TipoServicio implements ITipoServicio{

    private ITipoRepositorio repositorio;

    public TipoServicio(ITipoRepositorio repositorio) {
        this.repositorio = repositorio;   
    }

    @Override
    public List<Tipo> listar() {
        return repositorio.findAll();

    }

    @Override
    public Tipo obtener(int id) {
        Optional<Tipo> tipo = repositorio.findById(id);
        return tipo.isEmpty() ? null : tipo.get();
    }

    @Override
    public List<Tipo> buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public Tipo agregar(Tipo tipo) {
        tipo.setId(0);
        return repositorio.save(tipo);
    }

    @Override
    public Tipo modificar(Tipo tipo) {
        Optional<Tipo> tipoEncontrada = repositorio.findAll(tipo.getId());
        return tipoEncontrada.isEmpty() ? null : repositorio.save(tipo);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    
}
