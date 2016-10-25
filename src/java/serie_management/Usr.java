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
 * @author Joffrey
 */
@Entity
@Table(name = "usr")
@NamedQueries({
    @NamedQuery(name = "Usr.findAll", query = "SELECT u FROM Usr u"),
    @NamedQuery(name = "Usr.findByIdUsr", query = "SELECT u FROM Usr u WHERE u.idUsr = :idUsr"),
    @NamedQuery(name = "Usr.findByNomUsr", query = "SELECT u FROM Usr u WHERE u.nomUsr = :nomUsr"),
    @NamedQuery(name = "Usr.findByPrenomUsr", query = "SELECT u FROM Usr u WHERE u.prenomUsr = :prenomUsr"),
    @NamedQuery(name = "Usr.findByMdp", query = "SELECT u FROM Usr u WHERE u.mdp = :mdp"),
    @NamedQuery(name = "Usr.findByAge", query = "SELECT u FROM Usr u WHERE u.age = :age"),
    @NamedQuery(name = "Usr.findByFemme", query = "SELECT u FROM Usr u WHERE u.femme = :femme")})
public class Usr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Usr")
    private Integer idUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom_Usr")
    private String nomUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Prenom_Usr")
    private String prenomUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MDP")
    private String mdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Femme")
    private boolean femme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsr")
    private Collection<Note> noteCollection;

    public Usr() {
    }

    public Usr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public Usr(Integer idUsr, String nomUsr, String prenomUsr, String mdp, int age, boolean femme) {
        this.idUsr = idUsr;
        this.nomUsr = nomUsr;
        this.prenomUsr = prenomUsr;
        this.mdp = mdp;
        this.age = age;
        this.femme = femme;
    }

    public Integer getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public String getNomUsr() {
        return nomUsr;
    }

    public void setNomUsr(String nomUsr) {
        this.nomUsr = nomUsr;
    }

    public String getPrenomUsr() {
        return prenomUsr;
    }

    public void setPrenomUsr(String prenomUsr) {
        this.prenomUsr = prenomUsr;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getFemme() {
        return femme;
    }

    public void setFemme(boolean femme) {
        this.femme = femme;
    }

    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsr != null ? idUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usr)) {
            return false;
        }
        Usr other = (Usr) object;
        if ((this.idUsr == null && other.idUsr != null) || (this.idUsr != null && !this.idUsr.equals(other.idUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Usr[ idUsr=" + idUsr + " ]";
    }
    
}
