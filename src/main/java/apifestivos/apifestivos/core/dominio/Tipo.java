package apifestivos.apifestivos.core.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Tipo {
    @Id
    private Long id;
    private String nombre;
    private String modoCalculo;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModoCalculo() {
        return modoCalculo;
    }

    public void setModoCalculo(String modoCalculo) {
        this.modoCalculo = modoCalculo;
    }
}
 


/*
@Table(name = "tipo")
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tipo")
    @GenericGenerator(name = "secuencia_tipo", strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name="tipo", length = 100, unique = true)
    private String tipo;

    //Constructores
    public Tipo() {
    }

    public Tipo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


        

}
*/