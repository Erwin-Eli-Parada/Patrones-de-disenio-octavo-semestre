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
 * @author ELI
 */
@Entity
@Table(name = "TIPOACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoactividad.findAll", query = "SELECT t FROM Tipoactividad t")
    , @NamedQuery(name = "Tipoactividad.findByIdtac", query = "SELECT t FROM Tipoactividad t WHERE t.idtac = :idtac")
    , @NamedQuery(name = "Tipoactividad.findByDescripcion", query = "SELECT t FROM Tipoactividad t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipoactividad.findByActividades", query = "SELECT t FROM Tipoactividad t WHERE t.actividades = :actividades")})
public class Tipoactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTAC")
    private Integer idtac;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "ACTIVIDADES")
    private String actividades;
    @OneToMany(mappedBy = "tipoactividad")
    private List<Indicadoressalud> indicadoressaludList;

    public Tipoactividad() {
    }

    public Tipoactividad(Integer idtac) {
        this.idtac = idtac;
    }

    public Integer getIdtac() {
        return idtac;
    }

    public void setIdtac(Integer idtac) {
        this.idtac = idtac;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    @XmlTransient
    public List<Indicadoressalud> getIndicadoressaludList() {
        return indicadoressaludList;
    }

    public void setIndicadoressaludList(List<Indicadoressalud> indicadoressaludList) {
        this.indicadoressaludList = indicadoressaludList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtac != null ? idtac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoactividad)) {
            return false;
        }
        Tipoactividad other = (Tipoactividad) object;
        if ((this.idtac == null && other.idtac != null) || (this.idtac != null && !this.idtac.equals(other.idtac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipoactividad[ idtac=" + idtac + " ]";
    }
    
}
