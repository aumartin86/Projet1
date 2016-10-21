/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Audrey
 */
@Named(value = "serieControl")
@ViewScoped
public class serieControl implements Serializable {

@EJB
 private serieDao serieDao;

 private Serie saisie; 
 private int id;
 private Serie file;

 
    public serieControl() {
     saisie = new Serie();
    }

    public Serie getSaisie() {
        return saisie;
    }

    public void setSaisie(Serie saisie) {
        this.saisie = saisie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public List<Serie> getAllSeries(){
        return serieDao.getSeries();
    }
    
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String supprimerSerie() {
        serieDao.supp(saisie);
        addMessage("Confirmation","La série "+saisie.getNomSerie()+" a bien été supprimé !");
        return "afficheSeries";
    }
     
    public String saveSerie() {
        System.err.println("sauvegarde serie resume :" + saisie.getResumeSerie());
        System.err.println("sauvegarde serie nom :" + saisie.getNomSerie());
        System.err.println("sauvegarde serie image :" + saisie.getAffiche());
        System.err.println("sauvegarde serie real :" + saisie.getIdRealisateur().getIdRealisateur());
        serieDao.saveSerie(saisie);
        addMessage("Confirmation","La série "+saisie.getNomSerie()+" a bien été ajouté !");
        return "afficheSeries";
    }
    
    public Serie getFile() {
        return file;
    }
 
    public void setFile(Serie file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Confirmation","Le fichier est bien chargé.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
