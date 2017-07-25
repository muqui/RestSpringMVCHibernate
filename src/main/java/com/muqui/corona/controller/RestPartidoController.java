/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muqui.corona.controller;

import com.muqui.corona.model.Partido;
import com.muqui.corona.service.RestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mq12
 */
@RestController
public class RestPartidoController {

    @Autowired
    RestService restService;

    /*
    GET partido
     */
    @RequestMapping(value = "/partido/{id}", method = RequestMethod.GET)
    public ResponseEntity getPartido(@PathVariable("id") int id) {

        Partido partido = restService.partidobyId(id);
        if (partido == null) {
            return new ResponseEntity("Partido no encontrado ID: " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(partido, HttpStatus.OK);
    }

    /*
     DELETE partido   
     */
    @RequestMapping(value = "/partido/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePartido(@PathVariable Integer id) {

        if (null == restService.deletePartido(id)) {
            return new ResponseEntity("Partido no encontrado ID: " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }
    /*
     INSERT partido   
     */
    @RequestMapping(value = "/partido", method = RequestMethod.POST)
    public ResponseEntity createPartido(@RequestBody Partido partido) {

        restService.insertar(partido);

        return new ResponseEntity(partido, HttpStatus.OK);
    }
    /*
     UPDATE partido   
     */

    @RequestMapping(value = "/partido/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePartido(@PathVariable Integer id, @RequestBody Partido partido) {

        if (restService.partidobyId(id) == null) {
            return new ResponseEntity("Partido no encontrado ID:" + id, HttpStatus.NOT_FOUND);
        } else {
            partido = restService.update(id, partido);
            return new ResponseEntity(partido, HttpStatus.OK);
        }

    }
      /*
    GET partidoS
     */
    @RequestMapping(value = "/partidos", method = RequestMethod.GET)
    public ResponseEntity getPartidoS() {

        List<Partido> partidos = restService.partidos();
        if (partidos == null) {
            return new ResponseEntity("Partido no encontrado ID: ", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(partidos, HttpStatus.OK);
    }
}
