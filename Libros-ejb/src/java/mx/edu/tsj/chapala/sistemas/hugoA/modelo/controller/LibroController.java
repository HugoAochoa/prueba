/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller;

import java.util.Optional;
import javax.ejb.Stateless;
import mx.edu.tsj.chapala.sistemas.hugoA.dao.LibroDAO;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Libro;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Stateless
public class LibroController implements LibroControllerLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Mensaje agregar(Libro libro) {
        LibroDAO l = new LibroDAO();
        Mensaje m = null;

        if (libro.getTitulo().isEmpty()
                || libro.getDescripcion().isEmpty()
                || libro.getPaginas() <= 0
                || libro.getAnio() == null
                || libro.getAutorIdautor() == null
                || libro.getEditorialIdeditorial() == null) {
            
            System.out.println("Campos incompletos");
            return m.CAMPOS_INCOMPLETOS;
        }

        Optional<Libro> libroEncontradoOptional = l.buscarLibro(libro);
        if (libroEncontradoOptional.isPresent()) {
            libroEncontradoOptional.get();
            System.out.println("Elemento duplicado");
            return m.ELEMENTO_DUPLICADO;
        } else {
            l.agregar(libro);
            System.out.println("Sin errores, agregado correctamente");
            return m.SIN_ERROR;
        }
        
    }

    @Override
    public Libro buscarId(Libro libro) {
        LibroDAO l = new LibroDAO();

        return l.buscarId(libro);
    }

    @Override
    public Mensaje eliminar(Libro libro) {
        LibroDAO l = new LibroDAO();
        Mensaje m= null;
        if (l.eliminar(libro)) {
            System.out.println("eliminado correctamente");
            return m.SIN_ERROR;
        } else {
            System.out.println("El elemento no existe");
            return m.ELEMENTO_INEXISTENTE;
        }
    }

    @Override
    public Mensaje editar(Libro libro) {
        LibroDAO l = new LibroDAO();
        Mensaje m = null;
        if (libro.getTitulo().isEmpty()
                || libro.getDescripcion().isEmpty()
                || libro.getPaginas() <= 0
                || libro.getAnio() == null
                || libro.getAutorIdautor() == null
                || libro.getEditorialIdeditorial() == null) {
            System.out.println("Campos incompletos");
            return m.CAMPOS_INCOMPLETOS;
        }

        try {
            if (l.editar(libro) == true) {
                System.out.println("editado correctamente");
                return m.SIN_ERROR;
            } else {
                System.out.println("el elemento no existe");
                return m.ELEMENTO_INEXISTENTE;
            }

        } catch (Exception e) {
            System.out.println("Los datos son incorrectos");
            e.printStackTrace();
            return m.DATOS_INCORRECTOS;
        }
    }

}
