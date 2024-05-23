package apifestivos.apifestivos.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import apifestivos.apifestivos.core.dominio.Festivo;

public interface IFestivoRepositorio extends JpaRepository<Festivo, Long> {
    Festivo findByDiaAndMes(int dia, int mes);
}