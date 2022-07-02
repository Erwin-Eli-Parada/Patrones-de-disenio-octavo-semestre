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
 * @author ELI
 */
@Entity
@Table(name = "INVABARROTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invabarrote.findAll", query = "SELECT i FROM Invabarrote i")
    , @NamedQuery(name = "Invabarrote.findByIdavr", query = "SELECT i FROM Invabarrote i WHERE i.idavr = :idavr")
    , @NamedQuery(name = "Invabarrote.findByNombre", query = "SELECT i FROM Invabarrote i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Invabarrote.findByCantidadtienda", query = "SELECT i FROM Invabarrote i WHERE i.cantidadtienda = :cantidadtienda")
    , @NamedQuery(name = "Invabarrote.findByCantidadbodega", query = "SELECT i FROM Invabarrote i WHERE i.cantidadbodega = :cantidadbodega")
    , @NamedQuery(name = "Invabarrote.findByUnidadmedida", query = "SELECT i FROM Invabarrote i WHERE i.unidadmedida = :unidadmedida")
    , @NamedQuery(name = "Invabarrote.findByCostounit", query = "SELECT i FROM Invabarrote i WHERE i.costounit = :costounit")})
public class Invabarrote implements Serializable {

    @OneToMany(mappedBy = "articulo")
    private List<Artvendidos> artvendidosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAVR")
    private Integer idavr;
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
    private Tipoabarrote tipo;

    public Invabarrote() {
    }

    public Invabarrote(Integer idavr) {
        this.idavr = idavr;
    }

    public Integer getIdavr() {
        return idavr;
    }

    public void setIdavr(Integer idavr) {
        this.idavr = idavr;
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

    public Tipoabarrote getTipo() {
        return tipo;
    }

    public void setTipo(Tipoabarrote tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavr != null ? idavr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invabarrote)) {
            return false;
        }
        Invabarrote other = (Invabarrote) object;
        if ((this.idavr == null && other.idavr != null) || (this.idavr != null && !this.idavr.equals(other.idavr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Invabarrote[ idavr=" + idavr + " ]";
    }

    @XmlTransient
    public List<Artvendidos> getArtvendidosList() {
        return artvendidosList;
    }

    public void setArtvendidosList(List<Artvendidos> artvendidosList) {
        this.artvendidosList = artvendidosList;
    }
    
}
