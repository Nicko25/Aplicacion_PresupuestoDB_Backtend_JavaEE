package app.data;

import app.domain.Ingreso;
import java.util.List;


public interface IngresoDao {
    
    public List<Ingreso> encontrarTodosIngresos();
    
    public Ingreso encontrarIngreso(Ingreso ingreso);
    
    public void insertarIngreso(Ingreso ingreso);
    
    public void actualizarIngreso(Ingreso ingreso);
    
    public void eliminarIngreso(Ingreso ingreso);
    
}
