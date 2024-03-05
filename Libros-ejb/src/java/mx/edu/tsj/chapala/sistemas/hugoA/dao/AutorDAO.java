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
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Autor;
        
/**
 *
 * @author hugoa
 */
public class AutorDAO {
    private EntityManager em;

    public AutorDAO() {
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("Libros-ejbPU");
    em=emf.createEntityManager();
    }
    
    public void agregar(Autor a){
        em.getTransaction().begin();
        em.persist(a);//almacena en la base de datos
        em.getTransaction().commit();
    }
    public boolean editar(Autor a){
       if (buscarId(a) == null) {
            return false;
        } else {
            em.getTransaction().begin();
            em.merge(a);//edita en la base de datos
            em.getTransaction().commit();
            return true;
        }
    }
    public boolean eliminar(Autor a){
        
       if (buscarId(a) == null) {
            return false;
        } else {
            em.getTransaction().begin();
            em.remove(em.merge(a));  //eliminar en la base de datos
            em.getTransaction().commit();
            return true;
        }
         

    }
    
    public Autor buscarId(Autor a){
        Query q = em.createNamedQuery("Autor.findByIdautor");
        q.setParameter("idautor", a.getIdautor());
        if(q.getResultList().isEmpty()){
            return null;
        }else{
            return (Autor) q.getResultList().get(0);
        }
    }
    
    public Optional<Autor> buscarAutor(Autor a){
        Query ql = em.createNamedQuery("Autor.findByNombre");
        ql.setParameter("nombre", a.getNombre());
        
        Query q2 = em.createNamedQuery("Autor.findByPaterno");
        q2.setParameter("paterno", a.getPaterno());
        
        Query q3 = em.createNamedQuery("Autor.findByMaterno");
        q3.setParameter("materno", a.getMaterno());
        
        Query q4 = em.createNamedQuery("Autor.findByMail");
        q4.setParameter("mail", a.getMail());
        
        List<Autor> resNombre = ql.getResultList();
        List<Autor> resPaterno = q2.getResultList();
        List<Autor> resMaterno = q3.getResultList();
        List<Autor> resMail = q4.getResultList();
        
        if (!resNombre.isEmpty() && !resPaterno.isEmpty() && !resMaterno.isEmpty() && !resMail.isEmpty()){
            Autor encontrado = resNombre.stream()
                    .filter(resPaterno::contains)
                    .filter(resMaterno::contains)
                    .filter(resMail::contains)
                    .findFirst()
                    .orElse(null);
            return Optional.ofNullable(encontrado);
        }else{
            return Optional.empty();
        }
        
        
        
        
    }
    
   
    
}
