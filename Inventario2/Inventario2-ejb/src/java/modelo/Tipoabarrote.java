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
@Table(name = "TIPOABARROTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoabarrote.findAll", query = "SELECT t FROM Tipoabarrote t")
    , @NamedQuery(name = "Tipoabarrote.findByIdtipo", query = "SELECT t FROM Tipoabarrote t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tipoabarrote.findByNombre", query = "SELECT t FROM Tipoabarrote t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tipoabarrote.findByUso", query = "SELECT t FROM Tipoabarrote t WHERE t.uso = :uso")})
public class Tipoabarrote implements Serializable {

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
    @Column(name = "USO")
    private String uso;
    @OneToMany(mappedBy = "tipo")
    private List<Invabarrote> invabarroteList;

    public Tipoabarrote() {
    }

    public Tipoabarrote(Integer idtipo) {
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

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @XmlTransient
    public List<Invabarrote> getInvabarroteList() {
        return invabarroteList;
    }

    public void setInvabarroteList(List<Invabarrote> invabarroteList) {
        this.invabarroteList = invabarroteList;
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
        if (!(object instanceof Tipoabarrote)) {
            return false;
        }
        Tipoabarrote other = (Tipoabarrote) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipoabarrote[ idtipo=" + idtipo + " ]";
    }
    
}
