/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp;

import com.oracle.jrockit.jfr.ContentType;
import it.java858.todoapp.gui.Main;
import it.java858.todoapp.service.DbService;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.internal.jpa.deployment.xml.parser.PersistenceContentHandler;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
        System.out.println("Start jpa....");
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = DbService.getEm();
                //emf.createEntityManager();
         System.out.println("jpa....ok");
         ToDo td = new ToDo();
         td.setTesto("caffe tra poco...");
         td.setDataCreazione(new Date());
         em.getTransaction().begin();
         em.persist(td);
         em.getTransaction().commit();
         
         em.close();
    }
    
}
