package biglietteria;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="Biglietti")  

public class Biglietti implements  Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice")
    private long Codice;
    
    @Column(name="DataValidita")
    private Date DataValidita;
    
    @Column(name="Username",length=25)
    private String Titolo;
    
     @Column(name="CodiceAtt",length=8)
    private String TariffaOrdinaria;
     
    @ManyToOne
    @JoinColumn(name="attivitaBiglietto")
      private Attivita attivita;  
    

    public Biglietti() {
    }

    public long getCodice() {
        return Codice;
    }

    
    public Date getDataValidita() {
        return DataValidita;
    }

    public void setDataValidita(Date DataValidita) {
        this.DataValidita = DataValidita;
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
    
    
}
