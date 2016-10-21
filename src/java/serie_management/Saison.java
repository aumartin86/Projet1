/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "saison")
@NamedQueries({
    @NamedQuery(name = "Saison.findAll", query = "SELECT s FROM Saison s"),
    @NamedQuery(name = "Saison.findByIdSaison", query = "SELECT s FROM Saison s WHERE s.idSaison = :idSaison"),
    @NamedQuery(name = "Saison.findByNomSaison", query = "SELECT s FROM Saison s WHERE s.nomSaison = :nomSaison"),
    @NamedQuery(name = "Saison.findByAnneeSaison", query = "SELECT s FROM Saison s WHERE s.anneeSaison = :anneeSaison")})
public class Saison implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSaison")
    private Collection<Episode> episodeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Saison")
    private Integer idSaison;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Saison")
    private String nomSaison;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Annee_Saison")
    @Temporal(TemporalType.DATE)
    private Date anneeSaison;
    @JoinColumn(name = "Id_Serie", referencedColumnName = "Id_Serie")
    @ManyToOne(optional = false)
    private Serie idSerie;

    public Saison() {
    }

    public Saison(Integer idSaison) {
        this.idSaison = idSaison;
    }

    public Saison(Integer idSaison, String nomSaison, Date anneeSaison) {
        this.idSaison = idSaison;
        this.nomSaison = nomSaison;
        this.anneeSaison = anneeSaison;
    }

    public Integer getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(Integer idSaison) {
        this.idSaison = idSaison;
    }

    public String getNomSaison() {
        return nomSaison;
    }

    public void setNomSaison(String nomSaison) {
        this.nomSaison = nomSaison;
    }

    public Date getAnneeSaison() {
        return anneeSaison;
    }

    public void setAnneeSaison(Date anneeSaison) {
        this.anneeSaison = anneeSaison;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaison != null ? idSaison.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saison)) {
            return false;
        }
        Saison other = (Saison) object;
        if ((this.idSaison == null && other.idSaison != null) || (this.idSaison != null && !this.idSaison.equals(other.idSaison))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Saison[ idSaison=" + idSaison + " ]";
    }

    public Collection<Episode> getEpisodeCollection() {
        return episodeCollection;
    }

    public void setEpisodeCollection(Collection<Episode> episodeCollection) {
        this.episodeCollection = episodeCollection;
    }
    
}
