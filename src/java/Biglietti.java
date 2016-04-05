
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String DataValidita;
    
    @Column(name="Username",length=25)
    private String Titolo;
    
     @Column(name="CodiceAtt",length=8)
    private String TariffaOrdinaria;
     
    @OneToMany(mappedBy="biglietto")
    private Set<Biglietti>biglietto;

    public Biglietti() {
    }

    public String getDataValidita() {
        return DataValidita;
    }

    public void setDataValidita(String DataValidita) {
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

    public Set<Biglietti> getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Set<Biglietti> biglietto) {
        this.biglietto = biglietto;
    }
    
    
}
