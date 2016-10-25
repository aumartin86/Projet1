/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Joffrey
 */
@Named(value = "noteControl")
@ViewScoped
public class noteControl implements Serializable{

    @EJB
    private noteDao noteDao;
    private Note saisie; 

    /**
     * Creates a new instance of noteControl
     */
    public noteControl() {
    }

    public Note getSaisie() {
        return saisie;
    }

    public void setSaisie(Note saisie) {
        this.saisie = saisie;
    }
    
     public List<Note> getAllNotes(){
        return noteDao.getNotes();
    }
    
     public List<Note> getUnvalidNotes(){
        return noteDao.getUnvalidNotes();
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String supprimerNote() {
        noteDao.supp(saisie);
        addMessage("Confirmation","La note a bien été supprimée !");
        return "afficheNotes";
    }
     
    public String saveNote() {
        noteDao.saveNote(saisie);
        addMessage("Confirmation","La note a bien été ajoutée !");
        return "afficheNotes";
    }
    
        public String valider(){    
        saisie.setVerifie(1);
        noteDao.modifier(saisie);
        addMessage("Confirmation","La note a bien été validée !");
        return "afficheNotes";
    }   
    
}
