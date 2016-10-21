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
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Audrey
 */
@Named(value = "realisateurControl")
@ViewScoped

public class realisateurControl implements Serializable {

@EJB
 private realisateurDao realisateurDao;
 private Realisateur saisie; 
 private int id;
 
 public realisateurControl() {
     saisie = new Realisateur();
    }

    public Realisateur getSaisie() {
        return saisie;
    }

    public void setSaisie(Realisateur saisie) {
        this.saisie = saisie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public List<Realisateur> getAllRealisateur(){
        return realisateurDao.getRealisateurs();
    }
    
    public String saveRealisateur() {
        realisateurDao.saveRealisateur(saisie);
        addMessage("Confirmation","Le réalisateur "+saisie.getPrenomRealisateur()+" "+saisie.getNomRealisateur()+" a bien été ajouté !");
        return "ajoutRealisateur";
    }
        
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String supprimerRealisateur() {
        
        realisateurDao.supp(saisie);
        addMessage("Confirmation","Le réalisateur "+saisie.getPrenomRealisateur()+" "+saisie.getNomRealisateur()+" a bien été supprimé !");
        return "afficheRealisateur";
    }
    
    
    public String modifieRealisateur(){    
        realisateurDao.modifier(saisie);
        addMessage("Confirmation","Le réalisateur "+saisie.getPrenomRealisateur()+" "+saisie.getNomRealisateur()+" a bien été pris en compte !");
        return "afficheRealisateur";
    }  
    
    public String lireRealisateur(Integer id){
        saisie = realisateurDao.getOneRealisateur(id);
        return saisie.getNomRealisateur();
    }
}
