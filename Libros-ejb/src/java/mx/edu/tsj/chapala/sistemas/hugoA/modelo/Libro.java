/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tsj.chapala.sistemas.hugoA.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hugoa
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdlibro", query = "SELECT l FROM Libro l WHERE l.idlibro = :idlibro"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByDescripcion", query = "SELECT l FROM Libro l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Libro.findByPaginas", query = "SELECT l FROM Libro l WHERE l.paginas = :paginas"),
    @NamedQuery(name = "Libro.findByAnio", query = "SELECT l FROM Libro l WHERE l.anio = :anio")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibro")
    private Integer idlibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paginas")
    private int paginas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    @Temporal(TemporalType.DATE)
    private Date anio;
    @JoinColumn(name = "autor_idautor", referencedColumnName = "idautor")
    @ManyToOne(optional = false)
    private Autor autorIdautor;
    @JoinColumn(name = "editorial_ideditorial", referencedColumnName = "ideditorial")
    @ManyToOne(optional = false)
    private Editorial editorialIdeditorial;

    public Libro() {
    }

    public Libro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public Libro(Integer idlibro, String titulo, String descripcion, int paginas, Date anio) {
        this.idlibro = idlibro;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.paginas = paginas;
        this.anio = anio;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Autor getAutorIdautor() {
        return autorIdautor;
    }

    public void setAutorIdautor(Autor autorIdautor) {
        this.autorIdautor = autorIdautor;
    }

    public Editorial getEditorialIdeditorial() {
        return editorialIdeditorial;
    }

    public void setEditorialIdeditorial(Editorial editorialIdeditorial) {
        this.editorialIdeditorial = editorialIdeditorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibro != null ? idlibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idlibro == null && other.idlibro != null) || (this.idlibro != null && !this.idlibro.equals(other.idlibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.tsj.chapala.sistemas.hugoA.modelo.Libro[ idlibro=" + idlibro + " ]";
    }
    
}
