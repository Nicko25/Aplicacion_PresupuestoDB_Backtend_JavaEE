package app.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import app.domain.Ingreso;

@Stateless
public class IngresoDaoImpl implements IngresoDao{
    
    @PersistenceContext (unitName = "PresupuestoPU")
    EntityManager em;

    @Override
    public List<Ingreso> encontrarTodosIngresos() {
        return em.createNamedQuery("Ingreso.encontrarTodosIngresos").getResultList();
    }

    @Override
    public Ingreso encontrarIngreso(Ingreso ingreso) {
        return em.find(Ingreso.class, ingreso.getId());
    }

    @Override
    public void insertarIngreso(Ingreso ingreso) {
        em.persist(ingreso);
        em.flush();
    }

    @Override
    public void actualizarIngreso(Ingreso ingreso) {
        em.merge(ingreso);
    }

    @Override
    public void eliminarIngreso(Ingreso ingreso) {
        em.remove(em.merge(ingreso));
    }
}
