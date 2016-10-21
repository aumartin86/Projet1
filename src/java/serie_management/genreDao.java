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
public class genreDao {

    @PersistenceContext(unitName = "Projet1PU")
    private EntityManager em;

    public List<Genre> getGenres(){
        System.err.println("DAO:getGenres");
        Query query = em.createNamedQuery("Genre.findAll");
        try {
        return query.getResultList();
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    

    
        //pour ajout
    public void saveGenre(Genre genre){
        em.persist(genre);
    }
    
    
    
        // pour suppression
    public void supp(Genre genre){
        System.err.println("DAO:delete");
        try{
        em.remove(em.merge(genre));
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void modifier(Genre genre){
        try{
        
        em.merge(genre);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public Genre getOneGenre(int idGenre){
        System.err.println("id="+idGenre);
        Query query = em.createNamedQuery("Genre.findByIdGenre").setParameter("idGenre", idGenre);
        return (Genre) query.getSingleResult();
    }
}
