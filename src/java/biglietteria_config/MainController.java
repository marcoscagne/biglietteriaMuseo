package biglietteria_config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import biglietteria.Attivita;
import biglietteria.Clienti;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Controller
public class MainController {

    public MainController() {
        Attivita a = new Attivita();
    }

    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        //map.put("eventi",);
        return "index";
    }

    @RequestMapping(value = "/registrazione")
    public String registrazione(ModelMap map) {
        return "registrazione";
    }

    @RequestMapping(value = "/controllaLogin", method = RequestMethod.POST)
    public String login(ModelMap map, @RequestParam(value = "nu", required = true) String nu, @RequestParam(value = "pass", required = true) String pass) {
        map.put("nomeUtente", nu);
        map.put("password", pass);
        return "test";
    }

}
