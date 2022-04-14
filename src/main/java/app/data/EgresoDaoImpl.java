package app.data;

import app.domain.Egreso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EgresoDaoImpl implements EgresoDao{
    
    @PersistenceContext (unitName = "PresupuestoPU")
    EntityManager em;

    @Override
    public List<Egreso> encontrarTodosEgresos() {
        return em.createNamedQuery("Egreso.encontrarTodosEgresos").getResultList();
    }

    @Override
    public Egreso encontrarEgreso(Egreso egreso) {
        return em.find(Egreso.class, egreso.getId());
    }

    @Override
    public void insertarEgreso(Egreso egreso) {
        em.persist(egreso);
        em.flush();
    }

    @Override
    public void actualizarEgreso(Egreso egreso) {
        em.merge(egreso);
    }

    @Override
    public void eliminarEgreso(Egreso egreso) {
        em.remove(em.merge(egreso));
    }
    
}
