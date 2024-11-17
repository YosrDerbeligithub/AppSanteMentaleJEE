package mvcModel;

import entities.Institut;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class InstitutServive
 */
@Stateless
@LocalBean
public class InstitutServive {

    /**
     * Default constructor. 
     */
    public InstitutServive() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="appSanteMentale")
    private EntityManager em;
    public Institut getInstitutByIdd(Integer id)
    {
        Institut fac = null;
     TypedQuery<Institut> query =
    em.createNamedQuery("Institut.findById",Institut.class);
     query.setParameter(1, id);
     fac = query.getSingleResult();
    return fac;
    } 

}
