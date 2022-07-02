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
 * @author Eli
 */
@Entity
@Table(name = "ARTVENDIDOSALI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artvendidosali.findAll", query = "SELECT a FROM Artvendidosali a")
    , @NamedQuery(name = "Artvendidosali.findByIdventa", query = "SELECT a FROM Artvendidosali a WHERE a.idventa = :idventa")
    , @NamedQuery(name = "Artvendidosali.findByCantidad", query = "SELECT a FROM Artvendidosali a WHERE a.cantidad = :cantidad")})
public class Artvendidosali implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVENTA")
    private Integer idventa;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @JoinColumn(name = "ARTICULO", referencedColumnName = "IDALIM")
    @ManyToOne
    private Invalimento articulo;
    @JoinColumn(name = "VENTA", referencedColumnName = "IDVENTA")
    @ManyToOne
    private Venta venta;

    public Artvendidosali() {
    }

    public Artvendidosali(Integer idventa) {
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

    public Invalimento getArticulo() {
        return articulo;
    }

    public void setArticulo(Invalimento articulo) {
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
        if (!(object instanceof Artvendidosali)) {
            return false;
        }
        Artvendidosali other = (Artvendidosali) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Artvendidosali[ idventa=" + idventa + " ]";
    }
    
}
