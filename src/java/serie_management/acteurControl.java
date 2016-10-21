/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.io.Serializable;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Audrey
 */

@Named(value = "acteurControl")

@ViewScoped

public class acteurControl implements Serializable {

@EJB
 private acteurDao acteurDao;
 private Acteur saisie; 
 private int id;
 
 public acteurControl() {
     saisie = new Acteur();
    }

    public Acteur getSaisie() {
        return saisie;
    }

    public void setSaisie(Acteur saisie) {
        this.saisie = saisie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public List<Acteur> getAllActeurs(){
        return acteurDao.getActeurs();
    }
    
    public String saveActeur() {
        acteurDao.saveActeur(saisie);
        addMessage("Confirmation","L'acteur "+saisie.getPrenomActeur()+" "+saisie.getNomActeur()+" a bien été ajouté !");
        return "ajoutActeur";
    }
        
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String supprimerActeur() {
        System.err.println("SupprimeActeur"+saisie.getPrenomActeur());
        acteurDao.supp(saisie);
        addMessage("Confirmation","L'acteur "+saisie.getPrenomActeur()+" "+saisie.getNomActeur()+" a bien été supprimé !");
        return "afficheActeur";
    }
    
    
    public String modifierActeur(){    
        acteurDao.modifier(saisie);
        addMessage("Confirmation","L'acteur "+saisie.getPrenomActeur()+" "+saisie.getNomActeur()+" a bien été pris en compte !");
        return "afficheActeur";
    }  
     

}
