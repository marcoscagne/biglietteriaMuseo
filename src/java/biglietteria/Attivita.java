/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity

@NamedQueries({
    @NamedQuery(
        name="attivitaVicine",
        query="FROM Attivita WHERE tipo=:tipo and data>:data ORDER BY data"
    ),
    @NamedQuery(
        name="allActivities",
        query="FROM Attivita ORDER BY data"
    ),
    @NamedQuery(
        name="attivitaById",
        query="FROM Attivita WHERE codice=:id"
    ),
    @NamedQuery(
        name="query1",
        query="FROM Attivita WHERE data> :dataI and data< :dataF"
    )
})

@Table(name = "Attivita")

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
    @Column(name = "descrizione")
    private String descrizione;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
