package mvcModel;

import entities.Psychiatre;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class PsychiatreService
 */
@Stateless
@LocalBean
public class PsychiatreService {

    /**
     * Default constructor. 
     */
    public PsychiatreService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="appSanteMentale")
    private EntityManager em;
    public Psychiatre getPsyById(Integer id)
    {
        Psychiatre psy = null;
     TypedQuery<Psychiatre> query =
    em.createNamedQuery("Psychiatre.findById",Psychiatre.class);
     query.setParameter(1, id);
     psy = query.getSingleResult();
    return psy;
    } 
    public Psychiatre getPsyByLoginAndPwd(String username, String pwd)
    {
    	Psychiatre psy = null;
     TypedQuery<Psychiatre> query =
    em.createNamedQuery("Psychiatre.findByPwdAndLogin",Psychiatre.class);
     query.setParameter(1, username);
     query.setParameter(2, pwd);
     psy = query.getSingleResult();
    return psy;
    } 

}
