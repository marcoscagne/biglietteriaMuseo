/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biglietteria_config;

import biglietteria.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with convenient method to get Session Factory object.
 *
 * @author FSEVERI\scagnellato3082
 */
public class HibernateUtil {

    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Attivita.class)
                .addAnnotatedClass(Biglietti.class)
                .addAnnotatedClass(Categorie.class)
                .addAnnotatedClass(Clienti.class)
                .addAnnotatedClass(Servizi.class)
                .configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
}
