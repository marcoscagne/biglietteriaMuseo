/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author FSEVERI\sturza2870
 */
public class Base implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Codice",length=8)
    private String Codice;
    
   @Column(name="DataInizio")
    private Date data;
     
    @Column(name="DataFine")
    private Date data;
}
