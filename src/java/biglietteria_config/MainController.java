package biglietteria_config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Controller
public class MainController {
    

    public MainController() {
    }    

    @RequestMapping(value="/")
    public String index(ModelMap map){
        return "index";
    }
    
    @RequestMapping(value="/registrazione")
    public String registrazione(ModelMap map){
        return "registrazione";
    }
    
    @RequestMapping(value="/controllaLogin")
    public String login(ModelMap map, @RequestParam(value="nu",required=true) String nu, @RequestParam(value="pass",required=true) String pass){
        map.put("nomeUtente",nu);
        return "test";
    }
    
}
