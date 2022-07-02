/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ELI
 */
@Entity
@Table(name = "ARTVENDIDOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artvendidos.findAll", query = "SELECT a FROM Artvendidos a")
    , @NamedQuery(name = "Artvendidos.findByIdventa", query = "SELECT a FROM Artvendidos a WHERE a.idventa = :idventa")
    , @NamedQuery(name = "Artvendidos.findByCantidad", query = "SELECT a FROM Artvendidos a WHERE a.cantidad = :cantidad")})
public class Artvendidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVENTA")
    private Integer idventa;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @JoinColumn(name = "ARTICULO", referencedColumnName = "IDAVR")
    @ManyToOne
    private Invabarrote articulo;
    @JoinColumn(name = "VENTA", referencedColumnName = "IDVENTA")
    @ManyToOne
    private Venta venta;

    public Artvendidos() {
    }

    public Artvendidos(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Invabarrote getArticulo() {
        return articulo;
    }

    public void setArticulo(Invabarrote articulo) {
        this.articulo = articulo;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artvendidos)) {
            return false;
        }
        Artvendidos other = (Artvendidos) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Artvendidos[ idventa=" + idventa + " ]";
    }
    
}
