/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Editorial;

/**
 *
 * @author hugoa
 */
public class EditorialDAO {

    
private EntityManager em;

    public EditorialDAO() {
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("Libros-ejbPU");
    em=emf.createEntityManager();
    }
    
    public void agregar(Editorial a){
        em.getTransaction().begin();
        em.persist(a);//almacena en la base de datos
        em.getTransaction().commit();
    }
    public boolean editar(Editorial a){
        if (buscarId(a) == null) {
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(a);//edita en la base de datos
            em.getTransaction().commit();
            return true;
        }

    }
    public boolean eliminar(Editorial a){
        
        if (buscarId(a) == null) {
            return false;
        } else {
            em.getTransaction().begin();
            em.remove(em.merge(a));  //eliminar en la base de datos
            em.getTransaction().commit();
            return true;
        }
         

    }
    
    public Editorial buscarId(Editorial a){
        Query q = em.createNamedQuery("Editorial.findByIdeditorial");
        q.setParameter("ideditorial", a.getIdeditorial());
        if(q.getResultList().isEmpty()){
            return null;
        }else{
            return (Editorial) q.getResultList().get(0);
        }
    }
    
    
    public Optional<Editorial> buscarEditorial(Editorial a){
        Query ql = em.createNamedQuery("Editorial.findByNombre");
        ql.setParameter("nombre", a.getNombre());
        
        Query q2 = em.createNamedQuery("Editorial.findByPais");
        q2.setParameter("pais", a.getPais());
            
        Query q4 = em.createNamedQuery("Editorial.findByMail");
        q4.setParameter("mail", a.getMail());
        
        List<Editorial> resNombre = ql.getResultList();
        List<Editorial> resPais = q2.getResultList();
        List<Editorial> resMail = q4.getResultList();
        
        if (!resNombre.isEmpty() && !resPais.isEmpty() && !resMail.isEmpty()){
            Editorial encontrado = resNombre.stream()
                    .filter(resPais::contains) 
                    .filter(resMail::contains)
                    .findFirst()
                    .orElse(null);
            return Optional.ofNullable(encontrado);
        }else{
            return Optional.empty();
        }
        
        
        
        
    }
    
    
    
}
