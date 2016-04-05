
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="Servizi")  

public class Servizi implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice",length=8)
    private long Codice;
     
    @Column(name="Descrizione",length=150)
    private String Descrizione;
    
    
    @Column(name="Prezzo",length=4)
    private String Prezzo;
    
    @ManyToMany
    @JoinTable(
            name="Bigl_Serv",
            joinColumns={@JoinColumn(name="CodiceServizio")},
            inverseJoinColumns={@JoinColumn(name="CodiceCodice")}
    )         
    private Set<Biglietti>biglietto;

    public Servizi() {
    }

    public long getCodice() {
        return Codice;
    }

    public void setCodice(long Codice) {
        this.Codice = Codice;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public String getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(String Prezzo) {
        this.Prezzo = Prezzo;
    }

    public Set<Biglietti> getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Set<Biglietti> biglietto) {
        this.biglietto = biglietto;
    }
    
    
   
    
  
     
   
}
