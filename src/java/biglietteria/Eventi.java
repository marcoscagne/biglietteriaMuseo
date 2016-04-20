/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Eventi")

public class Eventi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codice")
    private Integer codice;
    @Basic(optional = false)
    @Column(name = "DataInizio")
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Basic(optional = false)
    @Column(name = "DataFine")
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    @JoinColumn(name = "Codice", referencedColumnName = "Codice", insertable = false, updatable = false)
    //@OneToOne(optional = false)
    private Attivita attivita;

    public Eventi() {
    }

    public Eventi(Integer codice) {
        this.codice = codice;
    }

    public Eventi(Integer codice, Date dataInizio, Date dataFine) {
        this.codice = codice;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public Attivita getAttivita() {
        return attivita;
    }

    public void setAttivita(Attivita attivita) {
        this.attivita = attivita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventi)) {
            return false;
        }
        Eventi other = (Eventi) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biglietteria.Eventi[ codice=" + codice + " ]";
    }
    
}
