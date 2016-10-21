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
@Named(value = "genreControl")
@ViewScoped
public class genreControl implements Serializable {

    @EJB
    private genreDao genreDao;

    private Genre saisie;
    private int id;
    
    
 

    public genreControl() {
        saisie = new Genre();
    }

    public Genre getSaisie() {
        return saisie;
    }

    public void setSaisie(Genre saisie) {
                System.out.println("setSaisie");

        this.saisie = saisie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Genre> getAllGenres() {
        return genreDao.getGenres();
    }

    public String saveGenre() {
        genreDao.saveGenre(saisie);
        addMessage("Confirmation","Le genre "+saisie.getNomGenre()+" a bien été ajouté !");
        return "afficheGenres";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String supprimerGenre() {
        System.err.println("SupprimeGenre");
        genreDao.supp(saisie);
        addMessage("Confirmation","Le genre "+saisie.getNomGenre()+" a bien été supprimé !");
        return "afficheGenres";
    }
    
    public String modifier(){    
        genreDao.modifier(saisie);
        addMessage("Confirmation","Le genre "+saisie.getNomGenre()+" a bien été pris en compte !");
        return "afficheGenres";
    }   
    
    
    
    
    
    




}
        
        
