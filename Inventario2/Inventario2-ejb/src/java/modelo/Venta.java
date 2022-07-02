/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ELI
 */
@Entity
@Table(name = "VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByEmpleado", query = "SELECT v FROM Venta v WHERE v.empleado = :empleado")
    , @NamedQuery(name = "Venta.findByEfectivo", query = "SELECT v FROM Venta v WHERE v.efectivo = :efectivo")})
public class Venta implements Serializable {

    @OneToMany(mappedBy = "venta")
    private List<Artvendidosali> artvendidosaliList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVENTA")
    private Integer idventa;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 30)
    @Column(name = "EMPLEADO")
    private String empleado;
    @Column(name = "EFECTIVO")
    private Boolean efectivo;
    @OneToMany(mappedBy = "venta")
    private List<Artvendidos> artvendidosList;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Boolean getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Boolean efectivo) {
        this.efectivo = efectivo;
    }

    @XmlTransient
    public List<Artvendidos> getArtvendidosList() {
        return artvendidosList;
    }

    public void setArtvendidosList(List<Artvendidos> artvendidosList) {
        this.artvendidosList = artvendidosList;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ idventa=" + idventa + " ]";
    }

    @XmlTransient
    public List<Artvendidosali> getArtvendidosaliList() {
        return artvendidosaliList;
    }

    public void setArtvendidosaliList(List<Artvendidosali> artvendidosaliList) {
        this.artvendidosaliList = artvendidosaliList;
    }
    
}
