package entities;

import java.io.Serializable;

import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity

@NamedQueries({
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e"),
@NamedQuery(name="Etudiant.findByLoginAndPwd", query="Select e from Etudiant e where e.pwd=?2 and e.username=?1 "),
@NamedQuery(name="Etudiant.findById", query="SELECT e FROM Etudiant e where e.idEtudiant=?1")

}
)
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_etudiant")
	private int idEtudiant;

	private String email;

	private String filiere;

	private String niveau;

	private String nom;

	private String prenom;

	private String pwd;

	private String username;

	//bi-directional many-to-one association to Institut
	@ManyToOne
	@JoinColumn(name="id_institut")
	private Institut institut;

	//bi-directional many-to-one association to Rdv
	@OneToMany(mappedBy="etudiant", fetch=FetchType.EAGER)
	private List<Rdv> rdvs;

	public Etudiant() {
	}

	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFiliere() {
		return this.filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
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

	public List<Rdv> getRdvs() {
		return this.rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Rdv addRdv(Rdv rdv) {
		getRdvs().add(rdv);
		rdv.setEtudiant(this);

		return rdv;
	}

	public Rdv removeRdv(Rdv rdv) {
		getRdvs().remove(rdv);
		rdv.setEtudiant(null);

		return rdv;
	}

	

}