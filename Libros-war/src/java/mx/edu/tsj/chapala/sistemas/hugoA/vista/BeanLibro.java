/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.ejb.EJB;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Autor;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Editorial;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Libro;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller.LibroControllerLocal;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Named(value = "beanLibro")
@SessionScoped
public class BeanLibro implements Serializable {
    @EJB
    private LibroControllerLocal libroController;

    /**
     * Creates a new instance of BeanLibro
     */
    public BeanLibro() {
    }
    
    
     public String agregarL(){
        Libro l = new Libro();
        l.setTitulo("El aguas");
        l.setDescripcion("wwaaw");
        l.setPaginas(200);
        l.setAnio(Date.from(Instant.now()));
        
        Editorial e = new Editorial();
        e.setIdeditorial(2);
        Autor a = new Autor();
        a.setIdautor(2);
        
        l.setAutorIdautor(a);
        l.setEditorialIdeditorial(e);
        
        libroController.agregar(l);
        
        
        

        return "index.xhtml";
    }
    public String buscarL(){
        Libro l = new Libro();
        l.setIdlibro(2);
        if(libroController.buscarId(l) == null){
            System.out.println(Mensaje.ELEMENTO_INEXISTENTE);
        } else {
            System.out.println(Mensaje.SIN_ERROR);
        }
        return "index.xhtml";
    }
    public String editarL(){
        Libro l = new Libro();
        l.setIdlibro(2);
        
        l.setTitulo("el mundo");
        l.setDescripcion("aaaaaaa");
        l.setPaginas(500);
        l.setAnio(Date.from(Instant.now()));
        
        
        Editorial e = new Editorial();
        e.setIdeditorial(2);
        Autor a = new Autor();
        a.setIdautor(1);
        
        l.setAutorIdautor(a);
        l.setEditorialIdeditorial(e);
        
        libroController.editar(l);
        
        
        
        
        return "index.xhtml";
        
    }
    public String eliminarL(){
        Libro l = new Libro();
        l.setIdlibro(9);
        
        Autor a = new Autor();
        a.setIdautor(1);
        
        Editorial e = new Editorial();
        e.setIdeditorial(2);
        
        l.setAutorIdautor(a);
        l.setEditorialIdeditorial(e);
 
        
        libroController.eliminar(l);
        
        
        
        return "index.xhtml";
    }
    
}
