/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Biglietti")

@NamedQueries({
    @NamedQuery(
            name = "allTickets",
            query = "FROM Biglietti "
    ),
    @NamedQuery(
            name = "ticketsByName",
            query = "FROM Biglietti where Username= :name"
    ),
    @NamedQuery(
            name = "query2",
            query = "SELECT count(*) FROM Attivita a, Biglietti b WHERE b.codiceAtt=a.codice and b.codiceAtt= :codAtt"
    ),
    @NamedQuery(
            name = "query3",
            query = "SELECT sum(a.tariffaOrdinaria) FROM Attivita a, Biglietti b WHERE b.codiceAtt=a.codice and a.codice= :codAtt GROUP BY b.codiceAtt,a.titolo"
    )
})

public class Biglietti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codice")
    private Integer codice;
    @Basic(optional = false)
    @Column(name = "DataValidita")
    @Temporal(TemporalType.DATE)
    private Date dataValidita;
    @JoinTable(name = "Bigl_Serv", joinColumns = {
        @JoinColumn(name = "CodiceBiglietto", referencedColumnName = "Codice")}, inverseJoinColumns = {
        @JoinColumn(name = "CodiceServizio", referencedColumnName = "Codice")})
    @ManyToMany
    private Collection<Servizi> serviziCollection;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Clienti username;
    @JoinColumn(name = "CodiceAtt", referencedColumnName = "Codice")
    @ManyToOne(optional = false)
    private Attivita codiceAtt;

    public Biglietti() {
    }

    public Biglietti(Integer codice) {
        this.codice = codice;
    }

    public Biglietti(Integer codice, Date dataValidita) {
        this.codice = codice;
        this.dataValidita = dataValidita;
    }

    public Biglietti(Date dataValidita, Clienti username, Attivita codiceAtt) {
        this.dataValidita = dataValidita;
        this.username = username;
        this.codiceAtt = codiceAtt;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public Date getDataValidita() {
        return dataValidita;
    }

    public void setDataValidita(Date dataValidita) {
        this.dataValidita = dataValidita;
    }

    @XmlTransient
    public Collection<Servizi> getServiziCollection() {
        return serviziCollection;
    }

    public void setServiziCollection(Collection<Servizi> serviziCollection) {
        this.serviziCollection = serviziCollection;
    }

    public Clienti getUsername() {
        return username;
    }

    public void setUsername(Clienti username) {
        this.username = username;
    }

    public Attivita getCodiceAtt() {
        return codiceAtt;
    }

    public void setCodiceAtt(Attivita codiceAtt) {
        this.codiceAtt = codiceAtt;
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
        if (!(object instanceof Biglietti)) {
            return false;
        }
        Biglietti other = (Biglietti) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biglietteria.Biglietti[ codice=" + codice + " ]";
    }
    
}
