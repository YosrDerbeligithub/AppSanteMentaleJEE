package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Rdv;
import entities.Session;
import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class RdvService
 */
@Stateless
@LocalBean
public class RdvService {

    /**
     * Default constructor. 
     */
	
    public RdvService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="appSanteMentale")
    private EntityManager em;
    public List<Rdv> getAllRdvAvailablee()
    {
    List<Rdv> Rdv = new ArrayList<Rdv>();
    TypedQuery<Rdv> query =
     em.createNamedQuery("Rdv.findAll",Rdv.class);
    Rdv = query.getResultList();
   return Rdv;
    }
    public Rdv getRdvById(Integer id)
    {
    	Rdv rdv = null;
     TypedQuery<Rdv> query =
    em.createNamedQuery("Rdv.findById",Rdv.class);
     query.setParameter(1, id);
     rdv = query.getSingleResult();
    return rdv;
    } 
    public void deleteRdv(Integer id) {
    	Rdv rdv=em.find(Rdv.class, id);
    	if (rdv != null) {
            em.remove(rdv);
        }
    	
    	
    }
    
    public void insertRdv(Etudiant etd,Session sess) {
    	Rdv r=new Rdv();
    	r.setSession(sess);
    	r.setEtudiant(etd);
    	r.setNote("");
    	r.setLien("");
    	em.persist(r);
    	
    	
    }
    public void updateRdv(String note ,String lien,Rdv r) {
    	r.setLien(lien);
    	r.setNote(note);
    	em.merge(r);
    	
    }

}
