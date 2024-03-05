/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller;

import java.util.Optional;
import javax.ejb.Stateless;
import mx.edu.tsj.chapala.sistemas.hugoA.dao.EditorialDAO;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Editorial;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;



/**
 *
 * @author hugoa
 */
@Stateless
public class EditorialController implements EditorialControllerLocal {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Mensaje agregar(Editorial editorial) {
        EditorialDAO e = new EditorialDAO();
        Mensaje m = null;
        
         if (editorial.getNombre().isEmpty()
                || editorial.getPais().isEmpty()
                || editorial.getMail().isEmpty()) {
             System.out.println("Campos incompletos");
            return m.CAMPOS_INCOMPLETOS;
        }
        
        
        Optional<Editorial> editorialEcontradoOptional = e.buscarEditorial(editorial);
        
        if(editorialEcontradoOptional.isPresent()){
            editorialEcontradoOptional.get();
            System.out.println("Elemento duplicado");
           return m.ELEMENTO_DUPLICADO;
        }else{
            e.agregar(editorial);
            System.out.println("Sin errores, se agrego correctamente");
            return m.SIN_ERROR;
        }
        
    }
    
    @Override
    public Editorial buscarId(Editorial editorial) {
        EditorialDAO e =new EditorialDAO();
        
        return e.buscarId(editorial);
    }

    

    @Override
    public Mensaje eliminar(Editorial editorial) {
        EditorialDAO e =new EditorialDAO();
        Mensaje m= null;
        if (e.eliminar(editorial)) {
            System.out.println("Sin errores, se elimino correctamente");
            return m.SIN_ERROR;
        } else {
            System.out.println("Elemento inexistente");
            return m.ELEMENTO_INEXISTENTE;
        }
    }

    @Override
    public Mensaje editar(Editorial editorial) {
        EditorialDAO e =new EditorialDAO();
        Mensaje m = null;
        if (editorial.getNombre().isEmpty()
                || editorial.getPais().isEmpty()
                || editorial.getMail().isEmpty()) {
            System.out.println("Campos incompletos ");
            return m.CAMPOS_INCOMPLETOS;
            
        }

        try {
            // Editar la editorial solo si todas las validaciones son exitosas
            if (e.editar(editorial) == true) {
                System.out.println("Sin errores, se edito correctamente");
                
                return m.SIN_ERROR;
            } else {
                System.out.println("Elemento inexistente");
                return m.ELEMENTO_INEXISTENTE;
            }

        }catch (Exception e1) {

            System.out.println("Datos incorrectos");
            e1.printStackTrace();
            return m.DATOS_INCORRECTOS;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
