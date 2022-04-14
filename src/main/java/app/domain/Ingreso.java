package app.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Ingreso.encontrarTodosIngresos",query = "SELECT i FROM Ingreso i ORDER BY i.id")
})
public class Ingreso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; //PK
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "valor")
    private Double valor;
    
    public Ingreso(){
    }
    
    public Ingreso(int id){
        this.id = id;
    }

    public Ingreso(int idCliente, String descripcion, Double valor) {
        this.id = idCliente;
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
        return "Ingreso{" + "id=" + id+ ", descripcion=" + descripcion + ", valor=" + valor + '}';
    }

    
    
}
