package app.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "Egreso.encontrarTodosEgresos",query = "SELECT e FROM Egreso e ORDER BY e.id")
})
public class Egreso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; //PK
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "valor")
    private Double valor;

    public Egreso() {
    }

    public Egreso(int id) {
        this.id = id;
    }

    public Egreso(int id, String descripcion, Double valor) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Egreso{" + "id=" + id + ", descripcion=" + descripcion + ", valor=" + valor + '}';
    }
    
    
    
}
