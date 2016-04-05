
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FSEVERI\sturza2870
 */


@Entity 
@Table(name="Attivita")  

public class Attivita implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice")
    private long Codice;
    
    @Column(name="Titolo",length=35)
    private String Titolo;
    
     @Column(name="TariffaOrdinaria",length=4)
    private String TariffaOrdinaria;
     
      @Column(name="CodiceBiglietto",length=8)
    private String CodiceBiglietto;
      
      @ManyToOne
      @JoinColumn(name="CodiceAttivita")
      private Biglietti biglietto;

    public Attivita() {
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String Titolo) {
        this.Titolo = Titolo;
    }

    public String getTariffaOrdinaria() {
        return TariffaOrdinaria;
    }

    public void setTariffaOrdinaria(String TariffaOrdinaria) {
        this.TariffaOrdinaria = TariffaOrdinaria;
    }

    public String getCodiceBiglietto() {
        return CodiceBiglietto;
    }

    public void setCodiceBiglietto(String CodiceBiglietto) {
        this.CodiceBiglietto = CodiceBiglietto;
    }

    public Biglietti getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietti biglietto) {
        this.biglietto = biglietto;
    }
    
    
}