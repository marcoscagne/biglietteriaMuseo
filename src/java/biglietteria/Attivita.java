package biglietteria;


import java.io.Serializable;
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
@Table(name="Attivita")  

public class Attivita implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice",length=8)
    private int Codice;
    
    @Column(name="Titolo",length=35)
    private String Titolo;
    
     @Column(name="TariffaOrdinaria",length=4)
    private float TariffaOrdinaria;
     
    @OneToMany(mappedBy="biglietto") 
    private Set<Biglietti>biglietto;
      
    

    public Attivita() {
    }

    public int getCodice() {
        return Codice;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String Titolo) {
        this.Titolo = Titolo;
    }

    public float getTariffaOrdinaria() {
        return TariffaOrdinaria;
    }

    public void setTariffaOrdinaria(float TariffaOrdinaria) {
        this.TariffaOrdinaria = TariffaOrdinaria;
    }

    
    
}