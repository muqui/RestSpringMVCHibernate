/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muqui.corona.dao;

import com.muqui.corona.model.Partido;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mq12
 */
@Repository("restDao")
public class RestDaoImpl implements RestDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public Partido partidobyId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Partido where id= :id ");
        query.setParameter("id", id);
        List<?> list = query.list();
        if (list.size() > 0) {
            Partido partido = (Partido) list.get(0);
            return partido;
        } else {
            return null;
        }

    }

    public Integer deletePartido(Integer id) {
        Partido partido = partidobyId(id);
        Session session = this.sessionFactory.getCurrentSession();
        if (partido != null) {
             session.delete(partido);
             return id;
        }
        else{
        return null;
        }
       
    }

    public Partido insertar(Partido partido) {
       Session session = this.sessionFactory.getCurrentSession();
       Date fecha = null;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fecha = df.parse(partido.getFechaTemporal());
        } catch (ParseException ex) {
            Logger.getLogger(RestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        partido.setFecha(fecha);
        session.persist(partido);
        return  partido;
    }

    public Partido update(Integer id, Partido partido) {
         Session session = this.sessionFactory.getCurrentSession();
       partido.setId(id);
       session.update(partido);      
        return partido;
    }

    public List<Partido> partidos() {
         Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Partido");
        
        List<?> list = query.list();
        if (list.size() > 0) {
           
            return (List<Partido>) list;
        } else {
            return null;
        }
    }

}
