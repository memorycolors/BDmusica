/*Alumno : javier García Rosado */
package com.mycompany.musica.newpackage;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CatalogoMusica {

    public static void main(String[] args) {
        Map<String, String> emfProperties = new HashMap<String, String>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("musicaPU", emfProperties); // Comprobar nombre de la PU
        EntityManager em = emf.createEntityManager();

        // REALIZAR AQUÍ LAS OPERACIONES SOBRE LA BASE DE DATOS
        
        // GENEROS 
        //Generos pop 
        em.getTransaction().begin();
        Genero generoPop = new Genero();
        generoPop.setNombre("POP");

        //genero regaetton
        Genero generoReggaeton = new Genero();
        generoReggaeton.setNombre("Reggaeton");

        //genero rock 
        Genero generoRock = new Genero();
        generoRock.setNombre("Rock");

        // genero funk 
        Genero generoFunk = new Genero();
        generoFunk.setNombre("Funk");

        //album thriller 
        Album albumThriller = new Album();
        albumThriller.setNombre("Thriller");

        //canciones thriller
        Cancion cancionThriller = new Cancion();
        cancionThriller.setTitulo("Thriller");
        cancionThriller.setAlbum(albumThriller);
        cancionThriller.setCantante("Michael Jackson");
        cancionThriller.setGenero(generoPop);
        cancionThriller.setPrecio(BigDecimal.valueOf(0.99));
        cancionThriller.setFavorito(Boolean.TRUE);
        
        //GENEROS 
        em.persist(generoPop);
        em.persist(generoReggaeton);
        em.persist(generoRock);
        em.persist(generoFunk);
        
        //ALBUNES 
        em.persist(albumThriller);

        //CANCIONES 
        em.persist(cancionThriller);

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
