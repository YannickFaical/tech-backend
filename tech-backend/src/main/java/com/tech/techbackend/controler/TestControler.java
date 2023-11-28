package com.tech.techbackend.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping(path ="test")    // pour indiquer les url a traiter dans ce controller
public class TestControler {


    @GetMapping
    public List<String> getList(){
return List.of("yannick","albert");

    }
    @GetMapping(path="string")
    public String getString(){
        return " chaine de caractere transmise";
    }

}
