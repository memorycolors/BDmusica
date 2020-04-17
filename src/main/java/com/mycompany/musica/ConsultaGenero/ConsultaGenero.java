/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.musica.ConsultaGenero;

import com.mycompany.musica.newpackage.Genero;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Javi
 */
public class ConsultaGenero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, String> emfProperties = new HashMap<>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("musicaPU", emfProperties);
        EntityManager em = emf.createEntityManager();
        Query queryGenero = em.createNamedQuery("Genero.findAll");
        List<Genero> listGenero;
        listGenero = queryGenero.getResultList();
        listGenero.forEach((genero) -> {
            System.out.println(genero.getNombre());
        });

        //MODIFICACION DE OBJETO
        Query queryGeneroPop = em.createNamedQuery("Genero.findByNombre");
        queryGeneroPop.setParameter("nombre", "POP");
        List<Genero> listGeneroPop = queryGeneroPop.getResultList();
        listGeneroPop.stream().map((generoPop) -> {
            generoPop.setCodigo("PO");
            return generoPop;
        }).forEachOrdered((generoPop) -> {
            em.merge(generoPop);
        });

        //Funk
        Query queryGeneroFunk = em.createNamedQuery("Genero.findByNombre");
        queryGeneroFunk.setParameter("nombre", "Funk");
        List<Genero> listGeneroFunk = queryGeneroFunk.getResultList();
        listGeneroFunk.stream().map((generoFunk) -> {
            generoFunk.setCodigo("FU");
            return generoFunk;
        }).forEachOrdered((generoFunk) -> {
            em.merge(generoFunk);
        });

        //Reggaeton
        Query queryGeneroReggaeton = em.createNamedQuery("Genero.findByNombre");
        queryGeneroReggaeton.setParameter("nombre", "Reggaeton");
        List<Genero> listGeneroReggaeton = queryGeneroReggaeton.getResultList();
        listGeneroReggaeton.stream().map((generoReggaeton) -> {
            generoReggaeton.setCodigo("RE");
            return generoReggaeton;
        }).forEachOrdered((generoReggaeton) -> {
            em.merge(generoReggaeton);
        });

        // Rock
        Query queryGeneroRock = em.createNamedQuery("Genero.findByNombre");
        queryGeneroRock.setParameter("nombre", "Rock");
        List<Genero> listGeneroRock = queryGeneroRock.getResultList();
        em.getTransaction().begin();
        listGeneroRock.stream().map((generoRock) -> {
            generoRock.setCodigo("RO");
            return generoRock;
        }).forEachOrdered((generoRock) -> {
            em.merge(generoRock);
        });

        

        //ELIMINAR OBJETOS 
        
        Genero generoId2 = em.find(Genero.class, 2);
        if (generoId2 != null) {
            em.remove(generoId2);
        } else {
            System.out.println("No hay ningun genero con ID=2");
        }
        
        em.getTransaction().commit();
        
        try {
            DriverManager.getConnection("jdbc:derby:BDmusica;shutdown=true");
        } catch (SQLException ex) {
        }
    }
}
