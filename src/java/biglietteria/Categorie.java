/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByCodice", query = "SELECT c FROM Categorie c WHERE c.codice = :codice"),
    @NamedQuery(name = "Categorie.findByTipoDoc", query = "SELECT c FROM Categorie c WHERE c.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Categorie.findByPercSconto", query = "SELECT c FROM Categorie c WHERE c.percSconto = :percSconto"),
    @NamedQuery(name = "Categorie.findByDescrizione", query = "SELECT c FROM Categorie c WHERE c.descrizione = :descrizione")})
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codice")
    private Integer codice;
    @Basic(optional = false)
    @Column(name = "TipoDoc")
    private String tipoDoc;
    @Basic(optional = false)
    @Column(name = "PercSconto")
    private long percSconto;
    @Basic(optional = false)
    @Column(name = "Descrizione")
    private String descrizione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceCat")
    private Collection<Clienti> clientiCollection;

    public Categorie() {
    }

    public Categorie(Integer codice) {
        this.codice = codice;
    }

    public Categorie(Integer codice, String tipoDoc, long percSconto, String descrizione) {
        this.codice = codice;
        this.tipoDoc = tipoDoc;
        this.percSconto = percSconto;
        this.descrizione = descrizione;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public long getPercSconto() {
        return percSconto;
    }

    public void setPercSconto(long percSconto) {
        this.percSconto = percSconto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @XmlTransient
    public Collection<Clienti> getClientiCollection() {
        return clientiCollection;
    }

    public void setClientiCollection(Collection<Clienti> clientiCollection) {
        this.clientiCollection = clientiCollection;
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
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biglietteria.Categorie[ codice=" + codice + " ]";
    }
    
}
