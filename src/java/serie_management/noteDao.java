/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serie_management;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Joffrey
 */
@Stateless
public class noteDao {

    @PersistenceContext(unitName = "Projet1PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Note> getNotes(){
        Query query = em.createNamedQuery("Note.findAll");
        return query.getResultList();
    }
    
     public List<Note> getUnvalidNotes(){
     Query query = em.createNamedQuery("Note.findByVerifie").setParameter("verifie", 0);
     return query.getResultList();
    }
            // pour suppression
    public void supp(Note note){
        
        try{
        em.remove(em.merge(note));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
            //pour ajout
    public void saveNote(Note note){
        em.persist(note);
    }
    
    public void modifier(Note note){
        try{
        
        em.merge(note);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
