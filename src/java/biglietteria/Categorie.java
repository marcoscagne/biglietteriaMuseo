/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.util.Set;
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
    private Set<Clienti> clientiSet;

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
    public Set<Clienti> getClientiSet() {
        return clientiSet;
    }

    public void setClientiSet(Set<Clienti> clientiSet) {
        this.clientiSet = clientiSet;
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
