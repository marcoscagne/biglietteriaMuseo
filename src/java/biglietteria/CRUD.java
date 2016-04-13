package biglietteria;

import java.util.Date;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class CRUD {

    private static SessionFactory factory;

    /* Method to CREATE an activity in the database */
    public Integer addAttivita(String titolo, float tariffa) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer attivitaID = null;
        try {
            tx = session.beginTransaction();
            Attivita attivita = new Attivita();
            attivita.setTitolo(titolo);
            attivita.setTariffaOrdinaria(tariffa);
            attivitaID = (Integer) session.save(attivita);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return attivitaID;
    }
    
    /* Method to
     READ all the activities */
    public void listAttivita() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List attivita = session.createQuery("FROM Attivita").list();
            for (Iterator iterator = attivita.iterator(); iterator.hasNext();) {
                Attivita a = (Attivita) iterator.next();
                System.out.print("Titolo: " + a.getTitolo());
                System.out.print("Tariffa Ordinaria: " + a.getTariffaOrdinaria());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* Method to UPDATE activity for an employee */
    public void updateAttivita(Integer AttivitaID, String titolo, float tariffa) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Attivita attivita
                    = (Attivita) session.get(Attivita.class, AttivitaID);
            attivita.setTitolo(titolo);
            attivita.setTariffaOrdinaria(tariffa);
            session.update(attivita);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* Method to DELETE an activity from the records */
    public void deleteAttivita(Integer AttivitaID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Attivita attivita
                    = (Attivita) session.get(Attivita.class, AttivitaID);
            session.delete(attivita);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /*********************************************************************************************/
    
    /* Method to CREATE an client in the database */
    public Integer addCliente(String username, String pass, String nome, String cognome, String email){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer clienteID = null;
        try {
            tx = session.beginTransaction();
            Clienti cliente = new Clienti();
            cliente.setUsername(username);
            cliente.setPswd(pass);
            cliente.setNome(nome);
            cliente.setCognome(cognome);
            cliente.setEmail(email);
            clienteID = (Integer) session.save(cliente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clienteID;
    }
    
    /* Method to
     READ all the client */
    public void listClienti() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List cliente = session.createQuery("FROM Clienti").list();
            for (Iterator iterator = cliente.iterator(); iterator.hasNext();) {
                Clienti c = (Clienti) iterator.next();
                System.out.print("Username: " + c.getUsername());
                System.out.print("Nome: " + c.getNome());
                System.out.print("Cognome: " + c.getCognome());
                System.out.print("Email: " + c.getEmail());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* Method to UPDATE client for an employee */
    public void updateCliente(Integer ClienteID,String username,String pass, String nome, String cognome, String email) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Clienti cliente
                    = (Clienti) session.get(Clienti.class, ClienteID);
            cliente.setUsername(username);
            cliente.setPswd(pass);
            cliente.setNome(nome);
            cliente.setCognome(cognome);
            cliente.setEmail(email);
            session.update(cliente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* Method to DELETE a client from the records */
    public void deleteCliente(Integer ClienteID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Clienti cliente
                    = (Clienti) session.get(Clienti.class, ClienteID);
            session.delete(cliente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /*********************************************************************************************/
    
    /* Method to CREATE a ticket in the database */
    public Integer addBiglietto(Date dataValidita, String username, Attivita attivita){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer bigliettoID = null;
        try {
            tx = session.beginTransaction();
            Biglietti biglietto = new Biglietti();
            biglietto.setDataValidita(dataValidita);
            //biglietto.setAttivita(attivita);
            bigliettoID = (Integer) session.save(biglietto);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bigliettoID;
    }
    
    /* Method to
     READ all the tickets */
    public void listBiglietti() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List cliente = session.createQuery("FROM Clienti").list();
            for (Iterator iterator = cliente.iterator(); iterator.hasNext();) {
                Clienti c = (Clienti) iterator.next();
                System.out.print("Username: " + c.getUsername());
                System.out.print("Nome: " + c.getNome());
                System.out.print("Cognome: " + c.getCognome());
                System.out.print("Email: " + c.getEmail());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* Method to UPDATE activity for an employee */
    public void updateBiglietto(Integer ClienteID,String username,String pass, String nome, String cognome, String email) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Clienti cliente
                    = (Clienti) session.get(Clienti.class, ClienteID);
            cliente.setUsername(username);
            cliente.setPswd(pass);
            cliente.setNome(nome);
            cliente.setCognome(cognome);
            cliente.setEmail(email);
            session.update(cliente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /* Method to DELETE an activity from the records */
    public void deleteBiglietto(Integer ClienteID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Clienti cliente
                    = (Clienti) session.get(Clienti.class, ClienteID);
            session.delete(cliente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
