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
@Table(name="Clienti")  

public class Clienti implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Username",length=25)
    private String Username;
    
    @Column(name="Pswd",length=25)
    private String Pswd;
    
    @Column(name="Nome",length=30)
    private String Nome;
     
    @Column(name="Cognome",length=35)
    private String Cognome;
    
    @Column(name="email",length=100)
    private String email;
    
    @ManyToOne
    @JoinColumn(name="CodiceCat")
      private Categorie categorie;
    
    @OneToMany(mappedBy="biglietto")
    private Set<Biglietti>biglietto;  

    public Set<Biglietti> getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Set<Biglietti> biglietto) {
        this.biglietto = biglietto;
    }
    
    

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Clienti() {
    }

    public String getUsername() {
        return Username;
    }

    
    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPswd() {
        return Pswd;
    }

    public void setPswd(String Pswd) {
        this.Pswd = Pswd;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
    
    
}
