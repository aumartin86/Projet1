/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "serie")
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s ORDER BY s.nomSerie"),
    @NamedQuery(name = "Serie.findByIdSerie", query = "SELECT s FROM Serie s WHERE s.idSerie = :idSerie"),
    @NamedQuery(name = "Serie.findByNomSerie", query = "SELECT s FROM Serie s WHERE s.nomSerie = :nomSerie"),
    @NamedQuery(name = "Serie.findByResumeSerie", query = "SELECT s FROM Serie s WHERE s.resumeSerie = :resumeSerie"),
    @NamedQuery(name = "Serie.findByAffiche", query = "SELECT s FROM Serie s WHERE s.affiche = :affiche")})
public class Serie implements Serializable {

    @ManyToMany(fetch = FetchType.EAGER)
      @JoinTable(name = "JOUE",
        joinColumns = @JoinColumn(name = "id_Serie"),
        inverseJoinColumns = @JoinColumn(name = "id_Acteur"))
    private List<Acteur> acteurCollection;

    
    @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "EST",
        joinColumns = @JoinColumn(name = "id_Serie"),
        inverseJoinColumns = @JoinColumn(name = "id_Genre"))
    private List<Genre> genreCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSerie")
    private Collection<Saison> saisonCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Serie")
    private Integer idSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Serie")
    private String nomSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Resume_Serie")
    private String resumeSerie;
    @Size(max = 200)
    @Column(name = "Affiche")
    private String affiche;
    @JoinColumn(name = "Id_Realisateur", referencedColumnName = "Id_Realisateur")
    @ManyToOne(optional = false)
    private Realisateur idRealisateur;

    public Serie() {
    }

    public Serie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Serie(Integer idSerie, String nomSerie, String resumeSerie) {
        this.idSerie = idSerie;
        this.nomSerie = nomSerie;
        this.resumeSerie = resumeSerie;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    public String getResumeSerie() {
        return resumeSerie;
    }

    public void setResumeSerie(String resumeSerie) {
        this.resumeSerie = resumeSerie;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public Realisateur getIdRealisateur() {
        return idRealisateur;
    }

    public void setIdRealisateur(Realisateur idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerie != null ? idSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.idSerie == null && other.idSerie != null) || (this.idSerie != null && !this.idSerie.equals(other.idSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Serie[ idSerie=" + idSerie + " ]";
    }

    public Collection<Saison> getSaisonCollection() {
        return saisonCollection;
    }

    public void setSaisonCollection(Collection<Saison> saisonCollection) {
        this.saisonCollection = saisonCollection;
    }

    public List<Genre> getGenreCollection() {
        return genreCollection;
    }

    public void setGenreCollection(List<Genre> genreCollection) {
        this.genreCollection = genreCollection;
    }

    public List<Acteur> getActeurCollection() {
        return acteurCollection;
    }

    public void setActeurCollection(List<Acteur> acteurCollection) {
        this.acteurCollection = acteurCollection;
    }

    Serie find(Long valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    byte[] getBytes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
