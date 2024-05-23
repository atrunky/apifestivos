package apifestivos.apifestivos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import apifestivos.apifestivos.aplicacion.FestivoServicio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class FestivoControlador {

    @Autowired
    private FestivoServicio festivoServicio;

    @PostMapping("/esFestivo")
    public ResponseEntity<String> esFestivo(@Valid @RequestBody FechaRequest fechaRequest) {
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaRequest.getFecha(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fecha no válida");
        }
        String resultado = festivoServicio.verificarFestivo(fecha);
        return ResponseEntity.ok(resultado);
    }
}

class FechaRequest {
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Fecha debe estar en el formato YYYY-MM-DD")
    private String fecha;

    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}