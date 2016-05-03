package biglietteria_config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import CRUD.CRUD;
import biglietteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Controller
public class MainController {

    public MainController() {
        
    }

    @RequestMapping(value = "/")
    public String index(ModelMap map, @RequestParam(value = "m", required = false) String msg) {
        map.put("msg",msg);
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("attivita",c.listAttivita());
        return "index";
    }

    @RequestMapping(value = "/registrazione")
    public String registrazione(ModelMap map) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("categorie",c.listCategorie());
        return "registrazione";
    }

    @RequestMapping(value = "/controllaLogin", method = RequestMethod.POST)
    public String login(ModelMap map, @RequestParam(value = "nu", required = true) String nu, @RequestParam(value = "pass", required = true) String pass) {
        map.put("nomeUtente", nu);
        map.put("password", pass);
        return "controllaLogin";
    }
    
    @RequestMapping(value = "/confermaRegistrazione", method = RequestMethod.POST)
    public String confReg(ModelMap map, @RequestParam(value = "nome", required = true) String nome, @RequestParam(value = "cognome", required = true) String cognome, @RequestParam(value = "email", required = true) String email, @RequestParam(value = "nu", required = true) String nu, @RequestParam(value = "pass", required = true) String pass, @RequestParam(value = "cat", required = true) Integer cat) {
        String msg="";
        Categorie categ=new Categorie(cat);
        Clienti cl =  new Clienti(nu,pass,nome,cognome,email,categ);
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        boolean stato = c.saveCliente(cl);
        if(stato)
            msg="Registrazione avvenuta con successo! Effettua il login!";
        else
            msg="Il nome utente scelto esiste gia!";
        map.put("msg",msg);
        map.put("attivita",c.listAttivita());
        return "index";
    }
    
    @RequestMapping(value = "/modificaProfilo", method = RequestMethod.POST)
    public String modificaProfilo(ModelMap map, @RequestParam(value = "nome", required = true) String nome, @RequestParam(value = "cognome", required = true) String cognome, @RequestParam(value = "email", required = true) String email, @RequestParam(value = "nu", required = true) String nu, @RequestParam(value = "pass", required = true) String pass, @RequestParam(value = "cat", required = true) Integer cat) {
        String msg="";
        Categorie categ=new Categorie(cat);
        Clienti cl =  new Clienti(nu,pass,nome,cognome,email,categ);
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        boolean stato = c.updateCliente(cl);
        if(stato)
            msg="Aggiornamento profilo avvenuto con successo!";
        else
            msg="Errore nell'aggiornamento del profilo!";
        map.put("msg",msg);
        map.put("attivita",c.listAttivita());
        return "index";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(ModelMap map) {
        return "logout";
    }
    
    @RequestMapping(value = "/gallery")
    public String galleria(ModelMap map) {
        return "gallery";
    }
    
    @RequestMapping(value = "/profilo", method = RequestMethod.GET)
    public String profilo(ModelMap map, @RequestParam(value="nu",required=true) String nu) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("categorie",c.listCategorie());
        map.put("biglietti",c.bigliettiByName(nu));
        map.put("cliente",c.cliente(nu));
        return "profilo";
    }
    
    @RequestMapping(value = "/attivita")
    public String lista(ModelMap map) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("attivita",c.listTutteAttivita());
        return "lista-attivita";
    }
    
    @RequestMapping(value = "/compra", method = RequestMethod.POST)
    public String compra(ModelMap map, @RequestParam(value="id",required=true) Integer id, @RequestParam(value="data",required=true) String data) {
        map.put("id", id);
        map.put("data", data);
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("attivita",c.listAttivitaById(id));
        map.put("servizi",c.listServizi());
        return "compra";
    }
    
    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
    
    @RequestMapping(value = "/dettaglio", method = RequestMethod.GET)
    public String dettaglio(ModelMap map, @RequestParam(value="id",required=false) Integer id) {
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        map.put("attivitaID",c.listAttivitaById(id));
        return "dettaglio-attivita";
    }
    
    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public String end(ModelMap map, @RequestParam(value="data",required=true) String data, @RequestParam(value="user",required=true) String user, @RequestParam(value="costo",required=true) BigDecimal costo) {
        map.put("data",data);
        map.put("costo",costo);
        CRUD c = new CRUD(HibernateUtil.getSessionFactory());
        Clienti cl = c.cliente(user).get(0);
        Categorie cat = c.categoria(cl.getCodiceCat().getCodice());
        map.put("sconto",cat.getPercSconto());
        return "acquistato";
    }
    
    @RequestMapping(value = "/salvaCarrello", method = RequestMethod.GET)
    @ResponseBody
    public String salvaCarrello(@RequestParam(value="servizi[]") Integer[] servizi) {
        HttpSession sess  = this.session();
        sess.setAttribute("servizi", servizi); 
      return "put in cart!";
    }
}
