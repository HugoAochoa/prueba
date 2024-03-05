/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Editorial;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller.EditorialControllerLocal;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Named(value = "beanEditorial")
@SessionScoped
public class BeanEditorial implements Serializable {
    @EJB
    private EditorialControllerLocal editorialController;

    /**
     * Creates a new instance of BeanEditorial
     */
    public BeanEditorial() {
    }
    
    
     public String agregarE(){
        Editorial e = new Editorial();
        e.setNombre("librosx");
        e.setPais("Mexico");
        e.setMail("patitoxx34");
        editorialController.agregar(e);
    
        return "index.xhtml";
    }
    public String buscarE(){
        Editorial e = new Editorial();
        e.setIdeditorial(2);
        if(editorialController.buscarId(e) == null){
            System.out.println(Mensaje.ELEMENTO_INEXISTENTE);
        } else {
            System.out.println(Mensaje.SIN_ERROR);
        }
        return "index.xhtml";
    }
    public String editarE(){
        Editorial e = new Editorial();
        e.setIdeditorial(2);
        
        e.setNombre("EdMarquinos");
        e.setPais("Bolivia");
        e.setMail("EdMarq421");
        editorialController.editar(e);
        
        
        
        
        return "index.xhtml";
        
    }
    public String eliminarE(){
        Editorial e = new Editorial();
        e.setIdeditorial(7);
        
        editorialController.eliminar(e);
        
        
        
        return "index.xhtml";
    }
    
}
