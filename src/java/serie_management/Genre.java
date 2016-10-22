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
@Table(name = "genre")
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g order by g.nomGenre"),
    @NamedQuery(name = "Genre.findByIdGenre", query = "SELECT g FROM Genre g WHERE g.idGenre = :idGenre"),
    @NamedQuery(name = "Genre.findByNomGenre", query = "SELECT g FROM Genre g WHERE g.nomGenre = :nomGenre")})

public class Genre implements Serializable {

    @JoinTable(name = "est", joinColumns = {
        @JoinColumn(name = "Id_Genre", referencedColumnName = "Id_Genre")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_Serie", referencedColumnName = "Id_Serie")})
    @ManyToMany
    private Collection<Serie> serieCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Genre")
    private Integer idGenre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Genre")
    private String nomGenre;

    public Genre() {
    }

    public Genre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public Genre(Integer idGenre, String nomGenre) {
        this.idGenre = idGenre;
        this.nomGenre = nomGenre;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenre != null ? idGenre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.idGenre == null && other.idGenre != null) || (this.idGenre != null && !this.idGenre.equals(other.idGenre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomGenre;
    }

    public Collection<Serie> getSerieCollection() {
        return serieCollection;
    }

    public void setSerieCollection(Collection<Serie> serieCollection) {
        this.serieCollection = serieCollection;
    }
    
}
