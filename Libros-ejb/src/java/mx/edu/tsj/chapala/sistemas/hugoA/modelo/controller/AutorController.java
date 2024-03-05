/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller;

import java.util.Optional;
import javax.ejb.Stateless;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Autor;
import mx.edu.tsj.chapala.sistemas.hugoA.dao.AutorDAO;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Stateless
public class AutorController implements AutorControllerLocal {
// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public Mensaje agregar(Autor autor) {
        System.out.println("llego al metodo agregar");
        AutorDAO autorDao = new AutorDAO();
        Mensaje m = null;
        
        if (autor.getNombre().isEmpty()
                || autor.getPaterno().isEmpty()
                || autor.getMaterno().isEmpty()
                || autor.getMail().isEmpty()) {
           System.out.println("Campos incompletos");
            return m.CAMPOS_INCOMPLETOS;
            
        }
        
        Optional<Autor> autorEcontradoOptional = autorDao.buscarAutor(autor);
        
        if(autorEcontradoOptional.isPresent()){
             autorEcontradoOptional.get();
           System.out.println("Elemento duplicado");
             return m.ELEMENTO_DUPLICADO;
            
        }else{
            autorDao.agregar(autor);
            System.out.println("Sin errores, agregado correctamente");
            return m.SIN_ERROR;
            
        }
        
        
    }
   
    
    @Override
    public Autor buscarId(Autor autor) {
        AutorDAO a=new AutorDAO();
        return a.buscarId(autor);
    }

    @Override
    public Mensaje eliminar(Autor autor) {
        AutorDAO el = new AutorDAO();
        Mensaje m = null;
        if(el.eliminar(autor)){
           System.out.println("se elimino correctamente");
            return m.SIN_ERROR;
            
            
        }else{
          System.out.println("Elemento inexistente");
            return m.ELEMENTO_INEXISTENTE;
            
        }
       
        
    }

    @Override
    public Mensaje editar(Autor autor) {
        AutorDAO ed = new AutorDAO();
        Mensaje m = null;
        if (autor.getNombre().isEmpty()
                || autor.getPaterno().isEmpty()
                || autor.getMaterno().isEmpty()
                || autor.getMail().isEmpty()) {
            System.out.println("Campos incompletos");
                return m.CAMPOS_INCOMPLETOS;
                
            
        }

        try {
            // Editar el autor solo si todas las validaciones son exitosas
            if (ed.editar(autor) == true) {
              System.out.println("se edito correctamente");
                return m.SIN_ERROR;
                
            } else {
               System.out.println("Elemento inexistente");
               return m.ELEMENTO_INEXISTENTE;
                
            }

        } catch (Exception e) {

           System.out.println("Datos incorrectos");
            e.printStackTrace();
            return m.DATOS_INCORRECTOS;
            
            
        }
        
    }

   
    
    
    
    
    
    
    
}
