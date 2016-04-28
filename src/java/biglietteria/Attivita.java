/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity

@NamedQueries({
    @NamedQuery(
            name = "attivitaVicine",
            query = "FROM Attivita WHERE tipo=:tipo and data> :data ORDER BY data"
    )
})

@Table(name = "Attivita")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attivita.findAll", query = "SELECT a FROM Attivita a"),
    @NamedQuery(name = "Attivita.findByCodice", query = "SELECT a FROM Attivita a WHERE a.codice = :codice"),
    @NamedQuery(name = "Attivita.findByTipo", query = "SELECT a FROM Attivita a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Attivita.findByTitolo", query = "SELECT a FROM Attivita a WHERE a.titolo = :titolo"),
    @NamedQuery(name = "Attivita.findByTariffaOrdinaria", query = "SELECT a FROM Attivita a WHERE a.tariffaOrdinaria = :tariffaOrdinaria"),
    @NamedQuery(name = "Attivita.findByImmagine", query = "SELECT a FROM Attivita a WHERE a.immagine = :immagine"),
    @NamedQuery(name = "Attivita.findByData", query = "SELECT a FROM Attivita a WHERE a.data = :data"),
    @NamedQuery(name = "Attivita.findByDataFine", query = "SELECT a FROM Attivita a WHERE a.dataFine = :dataFine")})*/
public class Attivita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codice")
    private Integer codice;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
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
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "dataFine")
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceAtt")
    private Collection<Biglietti> bigliettiCollection;

    public Attivita() {
    }

    public Attivita(Integer codice) {
        this.codice = codice;
    }

    public Attivita(Integer codice, String tipo, String titolo, BigDecimal tariffaOrdinaria, String immagine, Date data) {
        this.codice = codice;
        this.tipo = tipo;
        this.titolo = titolo;
        this.tariffaOrdinaria = tariffaOrdinaria;
        this.immagine = immagine;
        this.data = data;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    @XmlTransient
    public Collection<Biglietti> getBigliettiCollection() {
        return bigliettiCollection;
    }

    public void setBigliettiCollection(Collection<Biglietti> bigliettiCollection) {
        this.bigliettiCollection = bigliettiCollection;
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
