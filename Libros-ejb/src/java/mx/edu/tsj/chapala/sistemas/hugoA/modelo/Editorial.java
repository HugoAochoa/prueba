/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hugoa
 */
@Entity
@Table(name = "editorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e"),
    @NamedQuery(name = "Editorial.findByIdeditorial", query = "SELECT e FROM Editorial e WHERE e.ideditorial = :ideditorial"),
    @NamedQuery(name = "Editorial.findByNombre", query = "SELECT e FROM Editorial e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Editorial.findByPais", query = "SELECT e FROM Editorial e WHERE e.pais = :pais"),
    @NamedQuery(name = "Editorial.findByMail", query = "SELECT e FROM Editorial e WHERE e.mail = :mail")})
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideditorial")
    private Integer ideditorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mail")
    private String mail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editorialIdeditorial")
    private List<Libro> libroList;

    public Editorial() {
    }

    public Editorial(Integer ideditorial) {
        this.ideditorial = ideditorial;
    }

    public Editorial(Integer ideditorial, String nombre, String pais, String mail) {
        this.ideditorial = ideditorial;
        this.nombre = nombre;
        this.pais = pais;
        this.mail = mail;
    }

    public Integer getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(Integer ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideditorial != null ? ideditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.ideditorial == null && other.ideditorial != null) || (this.ideditorial != null && !this.ideditorial.equals(other.ideditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.tsj.chapala.sistemas.hugoA.modelo.Editorial[ ideditorial=" + ideditorial + " ]";
    }
    
}
