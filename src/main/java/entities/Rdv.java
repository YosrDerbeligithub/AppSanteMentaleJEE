package entities;

import java.io.Serializable;

import jakarta.persistence.*;


/**
 * The persistent class for the rdv database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Rdv.findAll", query="SELECT r FROM Rdv r"),
@NamedQuery(name="Rdv.findById", query="SELECT r FROM Rdv r where r.idRdv=?1")



})
public class Rdv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rdv")
	private int idRdv;

	private String lien;

	@Lob
	private String note;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="id_etudiant")
	private Etudiant etudiant;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="id_session")
	private Session session;

	public Rdv() {
	}

	public int getIdRdv() {
		return this.idRdv;
	}

	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}

	public String getLien() {
		return this.lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}