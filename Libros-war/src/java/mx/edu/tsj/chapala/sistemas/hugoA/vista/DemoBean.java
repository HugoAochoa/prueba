/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Autor;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller.AutorControllerLocal;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Named(value = "demoBean")
@SessionScoped
public class DemoBean implements Serializable {

    

    

    @EJB
    private AutorControllerLocal autorController;
    
    



    /**
     * Creates a new instance of DemoBean
     */
    
    public DemoBean() {
    }
    
    ////////////////////////Autores/////////////////////////////////////////////
    public String metodo(){
        Autor a = new Autor();
        a.setNombre("pepe");
        a.setPaterno("Juegos");
        a.setMaterno("Jump");
        a.setMail("3335454");
        autorController.agregar(a);
        

        
        return "index.xhtml";
        
    }
    public String buscar(){
        Autor a = new Autor();
        a.setIdautor(2);
        if(autorController.buscarId(a) == null){
            System.out.println(Mensaje.ELEMENTO_INEXISTENTE);
        } else {
            System.out.println(Mensaje.SIN_ERROR);
        }
        
        return "index.xhtml";
    }
    
    public String editar(){
        Autor e = new Autor();
        e.setIdautor(1);
        System.out.println("encontre un autor...");
        e.setNombre("roberto");
        e.setPaterno("Carrillo");
        e.setMaterno("Barragan");
        e.setMail("442323");
        autorController.editar(e);
        
        
        
        
        return "index.xhtml";
        
    }
    public String eliminar(){
        Autor el = new Autor();
        el.setIdautor(2);
        
        autorController.eliminar(el);
   
        return "index.xhtml";
    }
    
    
    
   
    
    
    
    
}
