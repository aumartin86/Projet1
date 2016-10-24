/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Audrey
 */
@Entity
@Table(name = "acteur")
@NamedQueries({
    @NamedQuery(name = "Acteur.findAll", query = "SELECT a FROM Acteur a ORDER BY a.nomActeur"),
    @NamedQuery(name = "Acteur.findByIdActeur", query = "SELECT a FROM Acteur a WHERE a.idActeur = :idActeur"),
    @NamedQuery(name = "Acteur.findByNomActeur", query = "SELECT a FROM Acteur a WHERE a.nomActeur = :nomActeur"),
    @NamedQuery(name = "Acteur.findByPrenomActeur", query = "SELECT a FROM Acteur a WHERE a.prenomActeur = :prenomActeur")})
public class Acteur implements Serializable {

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "acteurCollection")  
    private Collection<Serie> serieCollection;


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Acteur")
    private Integer idActeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Acteur")
    private String nomActeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Prenom_Acteur")
    private String prenomActeur;

    public Acteur() {
    }

    public Acteur(Integer idActeur) {
        this.idActeur = idActeur;
    }

    public Acteur(Integer idActeur, String nomActeur, String prenomActeur) {
        this.idActeur = idActeur;
        this.nomActeur = nomActeur;
        this.prenomActeur = prenomActeur;
    }

    public Integer getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(Integer idActeur) {
        this.idActeur = idActeur;
    }

    public String getNomActeur() {
        return nomActeur;
    }

    public void setNomActeur(String nomActeur) {
        this.nomActeur = nomActeur;
    }

    public String getPrenomActeur() {
        return prenomActeur;
    }

    public void setPrenomActeur(String prenomActeur) {
        this.prenomActeur = prenomActeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActeur != null ? idActeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acteur)) {
            return false;
        }
        Acteur other = (Acteur) object;
        if ((this.idActeur == null && other.idActeur != null) || (this.idActeur != null && !this.idActeur.equals(other.idActeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Acteur[ idActeur=" + idActeur + " ]";
    }

    public Collection<Serie> getSerieCollection() {
        return serieCollection;
    }

    public void setSerieCollection(Collection<Serie> serieCollection) {
        this.serieCollection = serieCollection;
    }
    
}
