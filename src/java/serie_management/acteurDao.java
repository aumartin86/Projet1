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
 * @author Audrey
 */
@Stateless
public class acteurDao {

    @PersistenceContext(unitName = "Projet1PU")
    private EntityManager em;

    public List<Acteur> getActeurs(){
        Query query = em.createNamedQuery("Acteur.findAll");
        return query.getResultList();
    }

    //pour ajout
    public void saveActeur(Acteur acteur){
        em.persist(acteur);
    }

    // pour suppression
    public void supp(Acteur acteur){
        System.err.println("DAO:delete");
        try{
        em.remove(em.merge(acteur));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    //pour modification
    
    public void modifier(Acteur acteur){
        try{
        em.merge(acteur);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
