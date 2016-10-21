/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Audrey
 */
@Entity
@Table(name = "episode")
@NamedQueries({
    @NamedQuery(name = "Episode.findAll", query = "SELECT e FROM Episode e"),
    @NamedQuery(name = "Episode.findByIdEpisode", query = "SELECT e FROM Episode e WHERE e.idEpisode = :idEpisode"),
    @NamedQuery(name = "Episode.findByNomEpisode", query = "SELECT e FROM Episode e WHERE e.nomEpisode = :nomEpisode"),
    @NamedQuery(name = "Episode.findByDatedesortie", query = "SELECT e FROM Episode e WHERE e.datedesortie = :datedesortie"),
    @NamedQuery(name = "Episode.findByResumeEpisode", query = "SELECT e FROM Episode e WHERE e.resumeEpisode = :resumeEpisode")})
public class Episode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Episode")
    private Integer idEpisode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Episode")
    private String nomEpisode;
    @Column(name = "Date_de_sortie")
    @Temporal(TemporalType.DATE)
    private Date datedesortie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Resume_Episode")
    private String resumeEpisode;
    @JoinColumn(name = "Id_Saison", referencedColumnName = "Id_Saison")
    @ManyToOne(optional = false)
    private Saison idSaison;

    public Episode() {
    }

    public Episode(Integer idEpisode) {
        this.idEpisode = idEpisode;
    }

    public Episode(Integer idEpisode, String nomEpisode, String resumeEpisode) {
        this.idEpisode = idEpisode;
        this.nomEpisode = nomEpisode;
        this.resumeEpisode = resumeEpisode;
    }

    public Integer getIdEpisode() {
        return idEpisode;
    }

    public void setIdEpisode(Integer idEpisode) {
        this.idEpisode = idEpisode;
    }

    public String getNomEpisode() {
        return nomEpisode;
    }

    public void setNomEpisode(String nomEpisode) {
        this.nomEpisode = nomEpisode;
    }

    public Date getDatedesortie() {
        return datedesortie;
    }

    public void setDatedesortie(Date datedesortie) {
        this.datedesortie = datedesortie;
    }

    public String getResumeEpisode() {
        return resumeEpisode;
    }

    public void setResumeEpisode(String resumeEpisode) {
        this.resumeEpisode = resumeEpisode;
    }

    public Saison getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(Saison idSaison) {
        this.idSaison = idSaison;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEpisode != null ? idEpisode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Episode)) {
            return false;
        }
        Episode other = (Episode) object;
        if ((this.idEpisode == null && other.idEpisode != null) || (this.idEpisode != null && !this.idEpisode.equals(other.idEpisode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Episode[ idEpisode=" + idEpisode + " ]";
    }
    
}
