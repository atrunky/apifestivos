package apifestivos.apifestivos.core.interfaces.servicios;

import java.util.List;

import apifestivos.apifestivos.core.dominio.Tipo;

public interface ITipoServicio {
    
    public List<Tipo> listar();

    public Tipo obtener(int id);

    public List<Tipo> buscar(String nombre);

    public Tipo agregar(Tipo Tipo);

    public Tipo modificar(Tipo Tipo);

    public boolean eliminar(int id);

}
