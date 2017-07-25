/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muqui.corona.dao;

import com.muqui.corona.model.Partido;
import java.util.List;

/**
 *
 * @author mq12
 */
public interface RestDao {
     public Partido partidobyId(int id);

    public Integer deletePartido(Integer id);

    public Partido insertar(Partido partido);

    public Partido update(Integer id, Partido partido);

    public List<Partido> partidos();
}
