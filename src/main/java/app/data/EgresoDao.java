package app.data;

import app.domain.Egreso;
import java.util.List;


public interface EgresoDao {
    
    public List<Egreso> encontrarTodosEgresos();
    
    public Egreso encontrarEgreso(Egreso egreso);
    
    public void insertarEgreso(Egreso egreso);
    
    public void actualizarEgreso(Egreso egreso);
    
    public void eliminarEgreso(Egreso egreso);
    
}
