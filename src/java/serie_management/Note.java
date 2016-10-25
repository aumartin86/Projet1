/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Joffrey
 */
@Entity
@Table(name = "note")
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdNote", query = "SELECT n FROM Note n WHERE n.idNote = :idNote"),
    @NamedQuery(name = "Note.findByValeurNote", query = "SELECT n FROM Note n WHERE n.valeurNote = :valeurNote"),
    @NamedQuery(name = "Note.findByCommentaire", query = "SELECT n FROM Note n WHERE n.commentaire = :commentaire"),
    @NamedQuery(name = "Note.findByFavori", query = "SELECT n FROM Note n WHERE n.favori = :favori"),
    @NamedQuery(name = "Note.findByVerifie", query = "SELECT n FROM Note n WHERE n.verifie = :verifie ORDER BY n.idNote DESC")})

public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Note")
    private Integer idNote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valeur_Note")
    private int valeurNote;
    @Size(max = 500)
    @Column(name = "Commentaire")
    private String commentaire;
    @Column(name = "Favori")
    private Boolean favori;
    @Column(name = "Verifie")
    private int verifie;
    @JoinColumn(name = "Id_Serie", referencedColumnName = "Id_Serie")
    @ManyToOne(optional = false)
    private Serie idSerie;
    @JoinColumn(name = "Id_Usr", referencedColumnName = "Id_Usr")
    @ManyToOne(optional = false)
    private Usr idUsr;

    public Note() {
    }

    public Note(Integer idNote) {
        this.idNote = idNote;
    }

    public Note(Integer idNote, int valeurNote) {
        this.idNote = idNote;
        this.valeurNote = valeurNote;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public int getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(int valeurNote) {
        this.valeurNote = valeurNote;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Boolean getFavori() {
        return favori;
    }

    public void setFavori(Boolean favori) {
        this.favori = favori;
    }

    public int getVerifie() {
        return verifie;
    }

    public void setVerifie(int verifie) {
        this.verifie = verifie;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }

    public Usr getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Usr idUsr) {
        this.idUsr = idUsr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "serie_management.Note[ idNote=" + idNote + " ]";
    }
    
}
