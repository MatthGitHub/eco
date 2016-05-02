/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eco.entidades;

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
 * @author Administrador
 */
@Entity
@Table(name = "senias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Senias.findAll", query = "SELECT s FROM Senias s"),
    @NamedQuery(name = "Senias.findByIdSenia", query = "SELECT s FROM Senias s WHERE s.idSenia = :idSenia"),
    @NamedQuery(name = "Senias.findByApellido", query = "SELECT s FROM Senias s WHERE s.apellido = :apellido"),
    @NamedQuery(name = "Senias.findByNombre", query = "SELECT s FROM Senias s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Senias.findByDni", query = "SELECT s FROM Senias s WHERE s.dni = :dni"),
    @NamedQuery(name = "Senias.findByTelefono", query = "SELECT s FROM Senias s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Senias.findByFecha", query = "SELECT s FROM Senias s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Senias.findByVencimiento", query = "SELECT s FROM Senias s WHERE s.vencimiento = :vencimiento"),
    @NamedQuery(name = "Senias.findByMontoSeniado", query = "SELECT s FROM Senias s WHERE s.montoSeniado = :montoSeniado"),
    @NamedQuery(name = "Senias.findByTotal", query = "SELECT s FROM Senias s WHERE s.total = :total")})
public class Senias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_senia")
    private Integer idSenia;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "vencimiento")
    @Temporal(TemporalType.DATE)
    private Date vencimiento;
    @Basic(optional = false)
    @Column(name = "monto_seniado")
    private String montoSeniado;
    @Basic(optional = false)
    @Column(name = "total")
    private String total;
    @JoinColumn(name = "fk_producto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto fkProducto;

    public Senias() {
    }

    public Senias(Integer idSenia) {
        this.idSenia = idSenia;
    }

    public Senias(Integer idSenia, String apellido, String nombre, String telefono, Date fecha, Date vencimiento, String montoSeniado, String total) {
        this.idSenia = idSenia;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
        this.vencimiento = vencimiento;
        this.montoSeniado = montoSeniado;
        this.total = total;
    }

    public Integer getIdSenia() {
        return idSenia;
    }

    public void setIdSenia(Integer idSenia) {
        this.idSenia = idSenia;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getMontoSeniado() {
        return montoSeniado;
    }

    public void setMontoSeniado(String montoSeniado) {
        this.montoSeniado = montoSeniado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Producto getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(Producto fkProducto) {
        this.fkProducto = fkProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSenia != null ? idSenia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Senias)) {
            return false;
        }
        Senias other = (Senias) object;
        if ((this.idSenia == null && other.idSenia != null) || (this.idSenia != null && !this.idSenia.equals(other.idSenia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eco.entidades.Senias[ idSenia=" + idSenia + " ]";
    }
    
}
