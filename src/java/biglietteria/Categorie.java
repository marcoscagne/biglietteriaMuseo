package biglietteria;


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
@Table(name="Categorie")  

public class Categorie implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice",length=8)
    private long Codice;
    
    @Column(name="TipoDoc",length=30)
    private String TipoDoc;
    
    @Column(name="PercSconto")
    private String percSconto;
     
    @Column(name="Descrizione",length=150)
    private String Descrizione;
      
    @ManyToOne
    @JoinColumn(name="CodiceCat")
      private Clienti cliente;

    public Categorie() {
    }

    public long getCodice() {
        return Codice;
    }

    public void setCodice(long Codice) {
        this.Codice = Codice;
    }

    public String getTipoDoc() {
        return TipoDoc;
    }

    public void setTipoDoc(String TipoDoc) {
        this.TipoDoc = TipoDoc;
    }

    public String getPercSconto() {
        return percSconto;
    }

    public void setPercSconto(String percSconto) {
        this.percSconto = percSconto;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public Clienti getCliente() {
        return cliente;
    }

    public void setCliente(Clienti cliente) {
        this.cliente = cliente;
    }
    
}
