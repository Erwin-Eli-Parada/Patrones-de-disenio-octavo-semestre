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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "INVALIMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invalimento.findAll", query = "SELECT i FROM Invalimento i")
    , @NamedQuery(name = "Invalimento.findByIdalim", query = "SELECT i FROM Invalimento i WHERE i.idalim = :idalim")
    , @NamedQuery(name = "Invalimento.findByNombre", query = "SELECT i FROM Invalimento i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Invalimento.findByCantidadtienda", query = "SELECT i FROM Invalimento i WHERE i.cantidadtienda = :cantidadtienda")
    , @NamedQuery(name = "Invalimento.findByCantidadbodega", query = "SELECT i FROM Invalimento i WHERE i.cantidadbodega = :cantidadbodega")
    , @NamedQuery(name = "Invalimento.findByUnidadmedida", query = "SELECT i FROM Invalimento i WHERE i.unidadmedida = :unidadmedida")
    , @NamedQuery(name = "Invalimento.findByCostounit", query = "SELECT i FROM Invalimento i WHERE i.costounit = :costounit")})
public class Invalimento implements Serializable {

    @OneToMany(mappedBy = "articulo")
    private List<Artvendidosali> artvendidosaliList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDALIM")
    private Integer idalim;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDADTIENDA")
    private Double cantidadtienda;
    @Column(name = "CANTIDADBODEGA")
    private Double cantidadbodega;
    @Size(max = 30)
    @Column(name = "UNIDADMEDIDA")
    private String unidadmedida;
    @Column(name = "COSTOUNIT")
    private Double costounit;
    @JoinColumn(name = "TIPO", referencedColumnName = "IDTIPO")
    @ManyToOne
    private Tipoalimfresco tipo;

    public Invalimento() {
    }

    public Invalimento(Integer idalim) {
        this.idalim = idalim;
    }

    public Integer getIdalim() {
        return idalim;
    }

    public void setIdalim(Integer idalim) {
        this.idalim = idalim;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidadtienda() {
        return cantidadtienda;
    }

    public void setCantidadtienda(Double cantidadtienda) {
        this.cantidadtienda = cantidadtienda;
    }

    public Double getCantidadbodega() {
        return cantidadbodega;
    }

    public void setCantidadbodega(Double cantidadbodega) {
        this.cantidadbodega = cantidadbodega;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public Double getCostounit() {
        return costounit;
    }

    public void setCostounit(Double costounit) {
        this.costounit = costounit;
    }

    public Tipoalimfresco getTipo() {
        return tipo;
    }

    public void setTipo(Tipoalimfresco tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalim != null ? idalim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invalimento)) {
            return false;
        }
        Invalimento other = (Invalimento) object;
        if ((this.idalim == null && other.idalim != null) || (this.idalim != null && !this.idalim.equals(other.idalim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Invalimento[ idalim=" + idalim + " ]";
    }

    @XmlTransient
    public List<Artvendidosali> getArtvendidosaliList() {
        return artvendidosaliList;
    }

    public void setArtvendidosaliList(List<Artvendidosali> artvendidosaliList) {
        this.artvendidosaliList = artvendidosaliList;
    }
    
}
