package entities;

import java.io.Serializable;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s where statut=0"),
@NamedQuery(name="Session.findById", query="SELECT s FROM Session s where s.idSession=?1")



})
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_session")
	private int idSession;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private short statut;

	//bi-directional many-to-one association to Rdv
	@OneToMany(mappedBy="session", fetch=FetchType.EAGER)
	private List<Rdv> rdvs;

	//bi-directional many-to-one association to Psychiatre
	@ManyToOne
	@JoinColumn(name="id_psychiatre")
	private Psychiatre psychiatre;

	public Session() {
	}

	public int getIdSession() {
		return this.idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public short getStatut() {
		return this.statut;
	}

	public void setStatut(short statut) {
		this.statut = statut;
	}

	public List<Rdv> getRdvs() {
		return this.rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Rdv addRdv(Rdv rdv) {
		getRdvs().add(rdv);
		rdv.setSession(this);

		return rdv;
	}

	public Rdv removeRdv(Rdv rdv) {
		getRdvs().remove(rdv);
		rdv.setSession(null);

		return rdv;
	}

	public Psychiatre getPsychiatre() {
		return this.psychiatre;
	}

	public void setPsychiatre(Psychiatre psychiatre) {
		this.psychiatre = psychiatre;
	}

}