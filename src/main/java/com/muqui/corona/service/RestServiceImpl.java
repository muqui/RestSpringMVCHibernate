/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muqui.corona.service;

import com.muqui.corona.dao.RestDao;
import com.muqui.corona.model.Partido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mq12
 */
@Service("restService")
@Transactional
public class RestServiceImpl implements RestService{
 @Autowired
    private RestDao dao;
    public Partido partidobyId(int id) {
        return dao.partidobyId(id);
    }

    public Integer deletePartido(Integer id) {
      return dao.deletePartido( id);
    }

    public Partido insertar(Partido partido) {
       return dao.insertar( partido);
    }

    public Partido update(Integer id, Partido partido) {
       return dao.update(id,partido);
    }

    public List<Partido> partidos() {
       return dao.partidos();
    }
    
}
