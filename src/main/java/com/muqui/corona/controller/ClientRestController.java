/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muqui.corona.controller;

import com.muqui.corona.model.Partido;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author mq12
 */
@Controller
public class ClientRestController {

    /*
        Get Partido
        
     */
    @RequestMapping(value = "/clientGetPartidoById/{id}", method = RequestMethod.GET)
    public String getPartidoID(ModelMap model, @PathVariable("id") int id) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        String getUrl = "http://localhost:8080/partido/" + id;
        ResponseEntity<Partido> entity = restTemplate.getForEntity(new URI(getUrl), Partido.class);
        HttpStatus statusCode = entity.getStatusCode();
        Partido partido = entity.getBody();
        model.addAttribute("partido", partido);
        return "inicio";
    }

    /*
        Delete Partido
        
     */
    @RequestMapping(value = "/clientDeletePartidoById/{id}", method = RequestMethod.GET)
    public String deletePartidoID(ModelMap model, @PathVariable("id") int id) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        String getUrl = "http://localhost:8080/partido/" + id;
        restTemplate.delete(getUrl);

        System.out.println("borrado");

        return "borrar";
    }

    /*
        Add Partido
        
     */
    @RequestMapping(value = "/clientAddPartido", method = RequestMethod.GET)
    public String addPartidoID(ModelMap model) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        Partido partido = new Partido("America", 0, "Queretaro", 1, "Azteca", new Date(), "1", "Apertura 2017");
        String getUrl = "http://localhost:8080/partido";
        Partido result = restTemplate.postForObject(getUrl, partido, Partido.class);
        System.out.println(result);
        System.out.println("Nombre321" + result.getEstadio());

        return "insertar";
    }

    @RequestMapping(value = "/clientUpdatePartido/{id}", method = RequestMethod.GET)
    public String updatePartidoID(ModelMap model, @PathVariable("id") int id) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
         String getUrl = "http://localhost:8080/partido/" + id;
        Partido partido = new Partido("America", 0, "Queretaro", 1, "Azteca", new Date(), "1", "Apertura 2017");
        restTemplate.put(getUrl, partido);

        System.out.println("Nombre321" + partido.getLocal());

        return "insertar";
    }

}
