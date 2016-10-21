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
public class realisateurDao {

    @PersistenceContext(unitName = "Projet1PU")
    private EntityManager em;

    public List<Realisateur> getRealisateurs(){
        Query query = em.createNamedQuery("Realisateur.findAll");
        return query.getResultList();
    }
    
    //pour ajout
    public void saveRealisateur(Realisateur real){
        em.persist(real);
    }

    // pour suppression
    public void supp(Realisateur real){
        
        try{
        em.remove(em.merge(real));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    //pour modification
    
    public void modifier(Realisateur real){
        try{
        em.merge(real);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    //rechercher à l'aide d'un identifiant
    
    public Realisateur getOneRealisateur(int id){
        Query query = em.createNamedQuery("Realisateur.findByIdRealisateur").setParameter("idRealisateur", id);
        try {
            return (Realisateur) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
