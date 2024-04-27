package apifestivos.apifestivos.core.dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivo")
    @GenericGenerator(name = "secuencia_festivo", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name="nombre", length = 100, unique = true)
    private String nombre;

    @Column(name="dia")
    private int dia;

    @Column(name="mes")
    private int mes;

    @Column(name = "diaspascua", length = 100, nullable = false)
    private String diaspascua;

    @ManyToOne
    @JoinColumn(name="IdTipo", referencedColumnName = "id")
    private Tipo tipo;

    public Festivo() {
    }

    public Festivo(int id, String nombre, int dia, int mes, String diaspascua, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diaspascua = diaspascua;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getDiaspascua() {
        return diaspascua;
    }

    public void setDiaspascua(String diaspascua) {
        this.diaspascua = diaspascua;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }



    
}