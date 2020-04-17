/*Alumno : javier García Rosado */
package com.mycompany.musica.newpackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class musica {

    public static void main(String[] args) {
        Map<String, String> emfProperties = new HashMap<String, String>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("musicaPU", emfProperties); // Comprobar nombre de la PU
        EntityManager em = emf.createEntityManager();

        // REALIZAR AQUÍ LAS OPERACIONES SOBRE LA BASE DE DATOS
        em.getTransaction().begin();
        Genero generoPop = new Genero();
        generoPop.setNombre("POP");
        
        Genero generoReggaeton = new Genero();
        generoReggaeton.setNombre("Reggaeton");
        
        Genero generoRock = new Genero();
        generoRock.setNombre("Rock");
        
        Genero generoFunk = new Genero();
        generoFunk.setNombre("Funk");

        
        em.persist(generoPop);
        em.persist(generoReggaeton);
        em.persist(generoRock);
        em.persist(generoFunk);
        
        
        em.getTransaction().commit();

        // Cerrar la conexión con la base de datos
        em.close();
        emf.close();
        try {
            DriverManager.getConnection("jdbc:derby:BDmusica;shutdown=true");
        } catch (SQLException ex) {
        }
    }

}
