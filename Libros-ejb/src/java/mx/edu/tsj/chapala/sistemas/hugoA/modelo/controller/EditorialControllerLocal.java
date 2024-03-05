/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo.controller;

import javax.ejb.Local;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.Editorial;
import mx.edu.tsj.chapala.sistemas.hugoA.modelo.msg.Mensaje;

/**
 *
 * @author hugoa
 */
@Local
public interface EditorialControllerLocal {

    Mensaje agregar(Editorial editorial);
    
    Editorial buscarId(Editorial editorial);

    Mensaje eliminar(Editorial editorial);

    Mensaje editar(Editorial editorial);
}
