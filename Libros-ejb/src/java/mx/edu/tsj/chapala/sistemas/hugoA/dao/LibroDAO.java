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
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Libro;

/**
 *
 * @author hugoa
 */
public class LibroDAO {
    
    private EntityManager em;

    public LibroDAO() {
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("Libros-ejbPU");
    em=emf.createEntityManager();
    }
    
    public void agregar(Libro a){
        em.getTransaction().begin();
        em.persist(a);//almacena en la base de datos
        em.getTransaction().commit();
    }
    public boolean editar(Libro a){
        if (buscarId(a) == null) {
            return true;
        } else {
            em.getTransaction().begin();
            em.merge(a);//edita en la base de datos
            em.getTransaction().commit();
            return true;
        }
    }
    public boolean eliminar(Libro a){
        
       if (buscarId(a) == null) {
            return false;
        } else {
            em.getTransaction().begin();
            em.remove(em.merge(a));  //eliminar en la base de datos
            em.getTransaction().commit();
            return true;
        }
         

    }
    
    public Libro buscarId(Libro a){
        Query q = em.createNamedQuery("Libro.findByIdlibro");
        q.setParameter("idlibro", a.getIdlibro());
        if(q.getResultList().isEmpty()){
            return null;
        }else{
            return (Libro) q.getResultList().get(0); //casting
        }
    }
    
    public Optional<Libro> buscarLibro(Libro a){
        Query ql = em.createNamedQuery("Libro.findByTitulo");
        ql.setParameter("titulo", a.getTitulo());
        
        Query q2 = em.createNamedQuery("Libro.findByDescripcion");
        q2.setParameter("descripcion", a.getDescripcion());
        
        Query q3 = em.createNamedQuery("Libro.findByPaginas");
        q3.setParameter("paginas", a.getPaginas());
        
        Query q4 = em.createNamedQuery("Libro.findByAnio");
        q4.setParameter("anio", a.getAnio());
        
        List<Libro> resTitulo = ql.getResultList();
        List<Libro> resDescripcion = q2.getResultList();
        List<Libro> resPaginas = q3.getResultList();
        List<Libro> resAnio = q4.getResultList();
        
        if (!resTitulo.isEmpty() && !resDescripcion.isEmpty() && !resPaginas.isEmpty() && !resAnio.isEmpty()){
            Libro encontrado = resTitulo.stream()
                    .filter(resDescripcion::contains)
                    .filter(resPaginas::contains)
                    .filter(resAnio::contains)
                    .findFirst()
                    .orElse(null);
            return Optional.ofNullable(encontrado);
        }else{
            return Optional.empty();
        }
        
        
        
        
    }
    
}
