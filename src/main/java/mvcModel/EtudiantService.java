package mvcModel;

import entities.Etudiant;
import entities.Institut;
import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class EtudiantService
 */
@Stateless
@LocalBean
public class EtudiantService {

    /**
     * Default constructor. 
     */
    public EtudiantService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="appSanteMentale")
    private EntityManager em;
    public Etudiant getStudentByLoginAndPwd(String login, String pwd)
    {
    	Etudiant std = null;
     TypedQuery<Etudiant> query =
    em.createNamedQuery("Etudiant.findByLoginAndPwd",Etudiant.class);
     query.setParameter(1, login);
     query.setParameter(2, pwd);
     std = query.getSingleResult();
    return std;
    } 
    public Etudiant getStudentById(Integer id)
    {
    	Etudiant std = null;
     TypedQuery<Etudiant> query =
    em.createNamedQuery("Etudiant.findById",Etudiant.class);
     query.setParameter(1, id);
     std = query.getSingleResult();
    return std;
    } 
    public void addEtudiant(String email,String prenom,String nom,String username,Institut institut,String filiere,String niveau,String pwd) {
    	Etudiant etd=new Etudiant();
    	etd.setEmail(email);
    	etd.setFiliere(filiere);
    	etd.setInstitut(institut);
    	etd.setNiveau(niveau);
    	etd.setNom(nom);
    	etd.setPrenom(prenom);
    	etd.setPwd(pwd);
    	etd.setUsername(username);
    	em.persist(etd);
    	
    }
    

}
