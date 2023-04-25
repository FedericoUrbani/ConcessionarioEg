package com.checkpoint3.Concessionario.controller;

import com.checkpoint3.Concessionario.entities.Auto;
import com.checkpoint3.Concessionario.entities.Concessionaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conc")
public class ConcessionarioController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome in the concessionario";
    }



    @GetMapping("/getauto/{auto_id}")
    public Auto getAuto (@PathVariable Integer auto_id){

        ArrayList<Auto> provList = new ArrayList<Auto>();
        
        Auto a1 = new Auto();
        a1.setId(1);
        a1.setCilindrata(3000);
        a1.setPlate("ANX8928");
        a1.setMarchio("marchio2");
        a1.setModello("modello3");

        Auto a2 = new Auto();
        a2.setId(2);
        a2.setCilindrata(4000);
        a2.setPlate("ANX6788");
        a2.setMarchio("marchio1");
        a2.setModello("modello2");

        provList.add(a1);
        provList.add(a2);
        

        Auto returnedAuto = null;
        try{
            for(Auto auto : provList){
                if(auto.getId() == auto_id){
                    returnedAuto=auto;
                }
            }
        }catch(IllegalArgumentException e){
            System.out.println("auto con id "+ auto_id+" non presente");
        }
        
        
        return returnedAuto;
    }

}
