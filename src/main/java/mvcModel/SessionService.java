package mvcModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Psychiatre;
import entities.Session;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class SessionService
 */
@Stateless
@LocalBean
public class SessionService {

    /**
     * Default constructor. 
     */
    public SessionService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="appSanteMentale")
    private EntityManager em;
    
    public List<Session> getAllSessionAvailable()
    {
    List<Session> sessions = new ArrayList<Session>();
    TypedQuery<Session> query =
     em.createNamedQuery("Session.findAll",Session.class);
    sessions = query.getResultList();
   return sessions;
    }
    public Session getSessionByIdd(Integer id)
    {
    	Session sess = null;
     TypedQuery<Session> query =
    em.createNamedQuery("Session.findById",Session.class);
     query.setParameter(1, id);
     sess = query.getSingleResult();
    return sess;
    } 
    public void insertSession(String date,String time,Psychiatre p) {
    	Session S=new Session();
    	Date d=new Date();
    	Integer year=Integer.parseInt(date.substring(0,4));
    	Integer month=Integer.parseInt(date.substring(5,7));
    	Integer day=Integer.parseInt(date.substring(8,10));
    	Integer hour=Integer.parseInt(time.substring(0,2));
    	Integer min=Integer.parseInt(time.substring(3,5));
    	d.setYear(year -1900);
    	d.setMonth(month -1);
    	d.setDate(day);
    	d.setHours(hour);
    	d.setMinutes(min);
    	d.setSeconds(0);
    	S.setDate(d);
    	S.setPsychiatre(p);
    	short s=(short)0;
    	S.setStatut(s);
    	em.persist(S);
    	
    }

	

}
