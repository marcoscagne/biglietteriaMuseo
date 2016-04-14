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
@Table(name="Categorie")  

public class Categorie implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice",length=8)
    private int Codice;
    
    @Column(name="TipoDoc",length=30)
    private String TipoDoc;
    
    @Column(name="PercSconto")
    private float percSconto;
     
    @Column(name="Descrizione",length=150)
    private String Descrizione;
      
    @OneToMany(mappedBy="CodiceCat")
    private Set<Clienti>cliente;

    public Set<Clienti> getCliente() {
        return cliente;
    }

    public Categorie() {
    }

    public int getCodice() {
        return Codice;
    }

  

    public String getTipoDoc() {
        return TipoDoc;
    }

    public void setTipoDoc(String TipoDoc) {
        this.TipoDoc = TipoDoc;
    }

    public float getPercSconto() {
        return percSconto;
    }

    public void setPercSconto(float percSconto) {
        this.percSconto = percSconto;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }
    
}
