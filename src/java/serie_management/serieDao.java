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
public class serieDao {

    @PersistenceContext(unitName = "Projet1PU")
    private EntityManager em;

    public List<Serie> getSeries(){
        Query query = em.createNamedQuery("Serie.findAll");
        return query.getResultList();
    }

            // pour suppression
    public void supp(Serie serie){
        
        try{
        em.remove(em.merge(serie));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
            //pour ajout
    public void saveSerie(Serie serie){
        em.persist(serie);
    }
    
    public void modifier(Serie serie){
        try{
        
        em.merge(serie);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
