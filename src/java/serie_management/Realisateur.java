/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Audrey
 */
@Entity
@Table(name = "realisateur")
@NamedQueries({
    @NamedQuery(name = "Realisateur.findAll", query = "SELECT r FROM Realisateur r"),
    @NamedQuery(name = "Realisateur.findByIdRealisateur", query = "SELECT r FROM Realisateur r WHERE r.idRealisateur = :idRealisateur"),
    @NamedQuery(name = "Realisateur.findByNomRealisateur", query = "SELECT r FROM Realisateur r WHERE r.nomRealisateur = :nomRealisateur"),
    @NamedQuery(name = "Realisateur.findByPrenomRealisateur", query = "SELECT r FROM Realisateur r WHERE r.prenomRealisateur = :prenomRealisateur")})
public class Realisateur implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRealisateur")
    private Collection<Serie> serieCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Realisateur")
    private Integer idRealisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Realisateur")
    private String nomRealisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Prenom_Realisateur")
    private String prenomRealisateur;

    public Realisateur() {
    }

    public Realisateur(Integer idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public Realisateur(Integer idRealisateur, String nomRealisateur, String prenomRealisateur) {
        this.idRealisateur = idRealisateur;
        this.nomRealisateur = nomRealisateur;
        this.prenomRealisateur = prenomRealisateur;
    }

    public Integer getIdRealisateur() {
        return idRealisateur;
    }

    public void setIdRealisateur(Integer idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public String getNomRealisateur() {
        return nomRealisateur;
    }

    public void setNomRealisateur(String nomRealisateur) {
        this.nomRealisateur = nomRealisateur;
    }

    public String getPrenomRealisateur() {
        return prenomRealisateur;
    }

    public void setPrenomRealisateur(String prenomRealisateur) {
        this.prenomRealisateur = prenomRealisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRealisateur != null ? idRealisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realisateur)) {
            return false;
        }
        Realisateur other = (Realisateur) object;
        if ((this.idRealisateur == null && other.idRealisateur != null) || (this.idRealisateur != null && !this.idRealisateur.equals(other.idRealisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Realisateur[ idRealisateur=" + idRealisateur + " ]";
    }

    public Collection<Serie> getSerieCollection() {
        return serieCollection;
    }

    public void setSerieCollection(Collection<Serie> serieCollection) {
        this.serieCollection = serieCollection;
    }
    
}
