/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eli
 */
@Entity
@Table(name = "TIPOALIMFRESCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoalimfresco.findAll", query = "SELECT t FROM Tipoalimfresco t")
    , @NamedQuery(name = "Tipoalimfresco.findByIdtipo", query = "SELECT t FROM Tipoalimfresco t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tipoalimfresco.findByNombre", query = "SELECT t FROM Tipoalimfresco t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tipoalimfresco.findByCaracteristica", query = "SELECT t FROM Tipoalimfresco t WHERE t.caracteristica = :caracteristica")})
public class Tipoalimfresco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPO")
    private Integer idtipo;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "CARACTERISTICA")
    private String caracteristica;
    @OneToMany(mappedBy = "tipo")
    private List<Invalimento> invalimentoList;

    public Tipoalimfresco() {
    }

    public Tipoalimfresco(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @XmlTransient
    public List<Invalimento> getInvalimentoList() {
        return invalimentoList;
    }

    public void setInvalimentoList(List<Invalimento> invalimentoList) {
        this.invalimentoList = invalimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoalimfresco)) {
            return false;
        }
        Tipoalimfresco other = (Tipoalimfresco) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipoalimfresco[ idtipo=" + idtipo + " ]";
    }
    
}
