/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Attivita")

public class Attivita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codice")
    private Integer codice;
    @Basic(optional = false)
    @Column(name = "Titolo")
    private String titolo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TariffaOrdinaria")
    private BigDecimal tariffaOrdinaria;
    @Basic(optional = false)
    @Column(name = "Immagine")
    private String immagine;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "attivita")
    private Eventi eventi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceAtt")
    private Set<Biglietti> bigliettiSet;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "attivita")
    private Base base;

    public Attivita() {
    }

    public Attivita(Integer codice) {
        this.codice = codice;
    }

    public Attivita(Integer codice, String titolo, BigDecimal tariffaOrdinaria, String immagine) {
        this.codice = codice;
        this.titolo = titolo;
        this.tariffaOrdinaria = tariffaOrdinaria;
        this.immagine = immagine;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public BigDecimal getTariffaOrdinaria() {
        return tariffaOrdinaria;
    }

    public void setTariffaOrdinaria(BigDecimal tariffaOrdinaria) {
        this.tariffaOrdinaria = tariffaOrdinaria;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public Eventi getEventi() {
        return eventi;
    }

    public void setEventi(Eventi eventi) {
        this.eventi = eventi;
    }

    @XmlTransient
    public Set<Biglietti> getBigliettiSet() {
        return bigliettiSet;
    }

    public void setBigliettiSet(Set<Biglietti> bigliettiSet) {
        this.bigliettiSet = bigliettiSet;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
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
        if (!(object instanceof Attivita)) {
            return false;
        }
        Attivita other = (Attivita) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biglietteria.Attivita[ codice=" + codice + " ]";
    }
    
}
