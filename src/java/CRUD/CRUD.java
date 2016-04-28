package CRUD;

import biglietteria.Attivita;
import biglietteria.Biglietti;
import biglietteria.Categorie;
import biglietteria.Clienti;
import biglietteria.Servizi;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class CRUD {

    private static SessionFactory factory;

    public CRUD(SessionFactory factory) {
        CRUD.factory = factory;
    }

    /* Method to CREATE an activity in the database */
    public Integer addAttivita(String titolo, BigDecimal tariffa) {
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
    public List<Attivita> listAttivita() {
        Session session = factory.openSession();
        ArrayList<Attivita> att = new ArrayList<Attivita>();
        att = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("attivitaVicine");

            /*Calendar cal = Calendar.getInstance();
            int day = cal.get(Calendar.DATE);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);*/
            Date d = new Date();
            
            //String currentDate = year+"-"+month+"-"+day;
            
            query.setParameter("data", d);
            query.setParameter("tipo", "evento");
            System.out.println("######################################"+d);
            List result = query.list();
            return result;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    /* Method to UPDATE activity for an employee */
    public void updateAttivita(Integer AttivitaID, String titolo, BigDecimal tariffa) {
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

    /**
     * ******************************************************************************************
     */
    /* Method to CREATE an client in the database */
    public Integer addCliente(String username, String pass, String nome, String cognome, String email) {
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
            List cliente = session.createSQLQuery("select * FROM Clienti").addEntity(Clienti.class).list();
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

    public String getPwdCliente(String nu) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List cliente = session.createSQLQuery("select * FROM Clienti").addEntity(Clienti.class).list();
            for (Iterator iterator = cliente.iterator(); iterator.hasNext();) {
                Clienti c = (Clienti) iterator.next();
                if (c.getUsername().equals(nu)) {
                    return c.getPswd();
                }
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
        return null;
    }

    /* Method to UPDATE client for an employee */
    public void updateCliente(Integer ClienteID, String username, String pass, String nome, String cognome, String email) {
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

    /**
     * ******************************************************************************************
     */
    /* Method to CREATE a ticket in the database */
    public Integer addBiglietto(Date dataValidita, String username, Attivita attivita) {
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
    public List<Biglietti> listBiglietti() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("allTickets");
            List<Biglietti> result = query.list();
            tx.commit();
            return result;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    /* Method to UPDATE tickets for an visitator */
    public void updateBiglietto(Integer BigliettiID, int Codice, Date DataValidita, Clienti cliente) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Biglietti biglietto
                    = (Biglietti) session.get(Biglietti.class, BigliettiID);
            biglietto.setDataValidita(DataValidita);
            biglietto.setUsername(cliente);

            session.update(biglietto);
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

    /* Method to DELETE a tickets from the records */
    public void deleteBiglietto(Integer BigliettiID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Biglietti biglietto
                    = (Biglietti) session.get(Biglietti.class, BigliettiID);
            session.delete(biglietto);
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

    /**
     * **************************************************************************
     */

    /* Method to CREATE a category in the database */
    public Integer addCategorie(String TipoDoc, long percSconto, String Descrizione) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer categoriaID = null;
        try {
            tx = session.beginTransaction();
            Categorie categoria = new Categorie();
            categoria.setTipoDoc(TipoDoc);
            categoria.setPercSconto(percSconto);
            categoria.setDescrizione(Descrizione);

            categoriaID = (Integer) session.save(categoria);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categoriaID;
    }

    /* Method to
     READ all the tickets */
    public void listCategorie() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List categoria = session.createQuery("FROM Categorie").list();
            for (Iterator iterator = categoria.iterator(); iterator.hasNext();) {
                Categorie c = (Categorie) iterator.next();
                System.out.print("Codice: " + c.getCodice());
                System.out.print("TipoDoc: " + c.getTipoDoc());
                System.out.print("PercSconto: " + c.getPercSconto());
                System.out.print("Descrizione: " + c.getDescrizione());

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
    public void updateCategorie(Integer categoriaID, int Codice, String TipoDoc, long percSconto, String Descrizione) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Categorie categoria
                    = (Categorie) session.get(Categorie.class, categoriaID);
            categoria.setTipoDoc(TipoDoc);
            categoria.setPercSconto(percSconto);
            categoria.setDescrizione(Descrizione);

            session.update(categoria);
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
    public void deleteCategoria(Integer categoriaID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Categorie categoria
                    = (Categorie) session.get(Categorie.class, categoriaID);
            session.delete(categoria);
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

    /**
     * ********************************************************************************
     */
    /* Method to CREATE a service in the database */
    public Integer addServizi(String Descrizione, BigDecimal prezzo) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer servizioID = null;
        try {
            tx = session.beginTransaction();
            Servizi servizio = new Servizi();
            servizio.setPrezzo(prezzo);
            servizio.setDescrizione(Descrizione);

            servizioID = (Integer) session.save(servizio);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return servizioID;
    }

    /* Method to
     READ all the services */
    public void listServizi() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List categoria = session.createQuery("FROM Servizi").list();
            for (Iterator iterator = categoria.iterator(); iterator.hasNext();) {
                Servizi s = (Servizi) iterator.next();
                System.out.print("Codice: " + s.getCodice());
                System.out.print("Descrizione: " + s.getDescrizione());
                System.out.print("Prezzo: " + s.getPrezzo());

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
    public void updateServizi(Integer servizioID, int Codice, String Descrizione, BigDecimal prezzo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Servizi servizio
                    = (Servizi) session.get(Servizi.class, servizioID);
            servizio.setPrezzo(prezzo);
            servizio.setDescrizione(Descrizione);

            session.update(servizio);
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
    public void deleteServizi(Integer servizioID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Servizi servizio
                    = (Servizi) session.get(Servizi.class, servizioID);
            session.delete(servizio);
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
