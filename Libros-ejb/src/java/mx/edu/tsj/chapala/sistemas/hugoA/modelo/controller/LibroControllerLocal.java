/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller;

import javax.ejb.Local;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Libro;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Local
public interface LibroControllerLocal {
    
    Mensaje agregar(Libro libro);
    
    Libro buscarId(Libro libro);

    Mensaje eliminar(Libro libro);

    Mensaje editar(Libro libro);
}
