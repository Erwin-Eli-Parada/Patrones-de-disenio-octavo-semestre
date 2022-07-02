/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ELI
 */
@Entity
@Table(name = "INDICADORESSALUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicadoressalud.findAll", query = "SELECT i FROM Indicadoressalud i")
    , @NamedQuery(name = "Indicadoressalud.findByIdindsalud", query = "SELECT i FROM Indicadoressalud i WHERE i.idindsalud = :idindsalud")
    , @NamedQuery(name = "Indicadoressalud.findByPeso", query = "SELECT i FROM Indicadoressalud i WHERE i.peso = :peso")
    , @NamedQuery(name = "Indicadoressalud.findByCintura", query = "SELECT i FROM Indicadoressalud i WHERE i.cintura = :cintura")
    , @NamedQuery(name = "Indicadoressalud.findByCadera", query = "SELECT i FROM Indicadoressalud i WHERE i.cadera = :cadera")
    , @NamedQuery(name = "Indicadoressalud.findByFecha", query = "SELECT i FROM Indicadoressalud i WHERE i.fecha = :fecha")})
public class Indicadoressalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINDSALUD")
    private Integer idindsalud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "CINTURA")
    private Integer cintura;
    @Column(name = "CADERA")
    private Integer cadera;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "TIPOACTIVIDAD", referencedColumnName = "IDTAC")
    @ManyToOne
    private Tipoactividad tipoactividad;
    @JoinColumn(name = "USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario usuario;

    public Indicadoressalud() {
    }

    public Indicadoressalud(Integer idindsalud) {
        this.idindsalud = idindsalud;
    }

    public Integer getIdindsalud() {
        return idindsalud;
    }

    public void setIdindsalud(Integer idindsalud) {
        this.idindsalud = idindsalud;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Integer getCadera() {
        return cadera;
    }

    public void setCadera(Integer cadera) {
        this.cadera = cadera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tipoactividad getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(Tipoactividad tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idindsalud != null ? idindsalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicadoressalud)) {
            return false;
        }
        Indicadoressalud other = (Indicadoressalud) object;
        if ((this.idindsalud == null && other.idindsalud != null) || (this.idindsalud != null && !this.idindsalud.equals(other.idindsalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Indicadoressalud[ idindsalud=" + idindsalud + " ]";
    }
    
}
