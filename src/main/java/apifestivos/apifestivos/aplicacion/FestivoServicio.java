package apifestivos.apifestivos.aplicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apifestivos.apifestivos.core.dominio.Festivo;
import apifestivos.apifestivos.core.interfaces.repositorios.IFestivoRepositorio;
import java.time.LocalDate;



@Service
public class FestivoServicio {

    @Autowired
    private IFestivoRepositorio festivoRepositorio;

    public String verificarFestivo(LocalDate fecha) {
        Festivo festivo = festivoRepositorio.findByDiaAndMes(fecha.getDayOfMonth(), fecha.getMonthValue());
        if (festivo != null) {
            return "Es festivo: " + festivo.getNombre();
        }
        // Lógica adicional para festivos basados en Pascua y Ley de "Puente festivo"
        return "No es festivo";
    }

    // Método para calcular la fecha de Pascua
    public LocalDate calcularPascua(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int days = d + e + 22;
        if (days > 31) {
            return LocalDate.of(year, 4, days - 31);
        } else {
            return LocalDate.of(year, 3, days);
        }
    }
}