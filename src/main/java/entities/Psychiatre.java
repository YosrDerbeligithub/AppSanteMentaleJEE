package entities;

import java.io.Serializable;

import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the psychiatre database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Psychiatre.findAll", query="SELECT p FROM Psychiatre p"),
@NamedQuery(name="Psychiatre.findById", query="SELECT p FROM Psychiatre p where p.idPsychiatre=?1"),
@NamedQuery(name="Psychiatre.findByPwdAndLogin", query="SELECT p FROM Psychiatre p where p.username=?1 and p.pwd=?2")

})
public class Psychiatre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_psychiatre")
	private int idPsychiatre;

	private String email;

	private String nom;

	private String prenom;

	private String pwd;

	private String specialite;

	private String username;

	//bi-directional many-to-one association to Institut
	@ManyToOne
	@JoinColumn(name="id_institut")
	private Institut institut;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="psychiatre", fetch=FetchType.EAGER)
	private List<Session> sessions;

	public Psychiatre() {
	}

	public int getIdPsychiatre() {
		return this.idPsychiatre;
	}

	public void setIdPsychiatre(int idPsychiatre) {
		this.idPsychiatre = idPsychiatre;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Institut getInstitut() {
		return this.institut;
	}

	public void setInstitut(Institut institut) {
		this.institut = institut;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setPsychiatre(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setPsychiatre(null);

		return session;
	}

}