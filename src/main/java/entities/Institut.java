package entities;

import java.io.Serializable;

import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the institut database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Institut.findAll", query="SELECT i FROM Institut i"),
@NamedQuery(name="Institut.findById", query="SELECT i FROM Institut i where i.idInstitut=?1")

})
public class Institut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_institut")
	private int idInstitut;

	@Column(name="nom_institut")
	private String nomInstitut;

	//bi-directional many-to-one association to Etudiant
	@OneToMany(mappedBy="institut", fetch=FetchType.EAGER)
	private List<Etudiant> etudiants;

	//bi-directional many-to-one association to Psychiatre
	@OneToMany(mappedBy="institut", fetch=FetchType.EAGER)
	private List<Psychiatre> psychiatres;

	public Institut() {
	}

	public int getIdInstitut() {
		return this.idInstitut;
	}

	public void setIdInstitut(int idInstitut) {
		this.idInstitut = idInstitut;
	}

	public String getNomInstitut() {
		return this.nomInstitut;
	}

	public void setNomInstitut(String nomInstitut) {
		this.nomInstitut = nomInstitut;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant addEtudiant(Etudiant etudiant) {
		getEtudiants().add(etudiant);
		etudiant.setInstitut(this);

		return etudiant;
	}

	public Etudiant removeEtudiant(Etudiant etudiant) {
		getEtudiants().remove(etudiant);
		etudiant.setInstitut(null);

		return etudiant;
	}

	public List<Psychiatre> getPsychiatres() {
		return this.psychiatres;
	}

	public void setPsychiatres(List<Psychiatre> psychiatres) {
		this.psychiatres = psychiatres;
	}

	public Psychiatre addPsychiatre(Psychiatre psychiatre) {
		getPsychiatres().add(psychiatre);
		psychiatre.setInstitut(this);

		return psychiatre;
	}

	public Psychiatre removePsychiatre(Psychiatre psychiatre) {
		getPsychiatres().remove(psychiatre);
		psychiatre.setInstitut(null);

		return psychiatre;
	}

}