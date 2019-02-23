package model;
import model.*;


import javax.jdo.JDOHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import javax.persistence.TypedQuery;
import javax.persistence.EntityTransaction;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class DBLogic {
   public DBLogic(){};
    Scanner in = new Scanner(System.in);

    /*
     @funkcja do dodawania uzytkownika
     */
    public void addUser() {

        System.out.println("\n");
        System.out.println("Podaj zarobek użytkownika: ");
        double userSalary = in.nextDouble();
        System.out.println("\n");
        System.out.println("Podaj numer telefonu: ");
        int tel = in.nextInt();
        System.out.println("\n");
        System.out.println("Podaj nazwę operatora telefonu: ");
        String op = in.nextLine();
        System.out.println("\n");
        System.out.println("Podaj email użytkownika: ");
        String email = in.nextLine();
        System.out.println("\n");
        System.out.println("Podaj imię użytkownika: ");
        String name = in.nextLine();
        System.out.println("\n");
        System.out.println("Podaj nazwisko użytkownika: ");
        String surname = in.nextLine();
        System.out.println("\n");
        System.out.println("Podaj wiek użytkownika: ");
        int age = in.nextInt();
        try {
            // Obtain a database connection:
            Properties properties = new Properties();
            properties.setProperty(
                    "javax.jdo.PersistenceManagerFactoryClass",
                    "com.objectdb.jdo.PMF");
            properties.setProperty(
                    "javax.jdo.option.ConnectionURL", "user.odb");
            PersistenceManagerFactory pmf =
                    JDOHelper.getPersistenceManagerFactory(properties);
            PersistenceManager pm = pmf.getPersistenceManager();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("user.odb");
            EntityManager em = emf.createEntityManager();

            try {


                pm.currentTransaction().begin();
                AccountLogger accountLogger = new AccountLogger(new Date(), new Date(), "Cracow");
                Salary salary = new Salary(45, userSalary, new Date());
                PhoneDetails phoneDetails = new PhoneDetails("office", tel, op);

                // Create and store a new User instance:
                UserDetails userDetails = new UserDetails.Builder()
                        .phone("3248232222")
                        .nickName("Testowiron")
                        .city("Kraków")
                        .birthDay(21)
                        .birthMonth(5)
                        .birthYear(1993)
                        .zipCode("44-335")
                        .avatar("http://www.google.pl/img/testowiron34")
                        .build();

                User user = new User(email, name, surname, age, true, true, userDetails, accountLogger, salary, phoneDetails);
                pm.makePersistent(user);
                pm.currentTransaction().commit();
            } finally {
                if (pm.currentTransaction().isActive())
                    pm.currentTransaction().rollback();
                if(!pm.isClosed())
                    pm.close();
            }
        } catch (RuntimeException x) {
            System.err.println("Error: " + x.getMessage());
        }
    }




    /*
     @funkcja do wyświetlania wszystkich użytkowników
     */
    public void viewUsers(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();
        try{

                TypedQuery<User> query =
                        em.createQuery("SELECT u FROM User u", User.class);
                List<User> results = query.getResultList();
                for (User u : results) {
                    System.out.println(u);
                }
        } finally {
            em.close();
            emf.close();
        }
    }

    /*
     @funkcja do wyświetlania nazwisk użytkowników
     */
    public void viewUserSurnames(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();
        try{

            TypedQuery<String> query =
                    em.createQuery("SELECT u.surname FROM User AS u", String.class);
            List<String> results = query.getResultList();
            for (String u : results) {
                System.out.println(u);
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    /*
     @funkcja do wyświetlania nazwisk użytkowników
     */
    public void viewUserNames(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();
        try{

            TypedQuery<Object[]> query =
                    em.createQuery("SELECT u.id, u.surname, u.name FROM User AS u", Object[].class);
            List<Object[]> results = query.getResultList();
            for (Object[] u : results) {
                System.out.println("id=" + u[0] + ", name=" + u[1] + ", surname=" + u[2]);
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    /*
    @funkcja do wyświetlania liczby uzytkownikow
    */
    public void countUsers(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();
        try{

            TypedQuery<User> query =
                    em.createQuery("SELECT COUNT(u) FROM User AS u", User.class);
          System.out.println("Liczba użytkowników na bazie = " +query.getSingleResult());
        } finally {
            em.close();
            emf.close();
        }
    }

    /*
   @funkcja do wyszukiwania uzytkownika z danym ID
   */
    public void searchUserByID(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("\nPodaj id użytkownika, którego szukasz: ");
            long id = in.nextLong();
            TypedQuery<User> query =
                    em.createQuery("SELECT u FROM User u WHERE u.id = ?1", User.class);
            List<User> results = query.setParameter(1, id).getResultList();
            for (User u : results) {
                System.out.println(u);
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    /*
  @funkcja do wyszukiwania uzytkownika z danym imieniem
  */
    public void searchUserByName(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("\nPodaj imię użytkownika/ów, którego/ych szukasz: ");
            String name = in.nextLine();
            TypedQuery<User> query =
                    em.createQuery("SELECT u FROM User u WHERE u.name = ?1", User.class);
            List<User> results = query.setParameter(1, name).getResultList();
            for (User u : results) {
                System.out.println(u);
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    /*
  @funkcja do wyszukiwania uzytkownika z danym nazwiskiem
  */
    public void searchUserBySurname(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("\nPodaj nazwisko użytkownika, którego szukasz: ");
            String surname = in.nextLine();
            TypedQuery<User> query =
                    em.createQuery("SELECT u FROM User u WHERE u.surname = ?1", User.class);
            List<User> results = query.setParameter(1, surname).getResultList();
            for (User u : results) {
                System.out.println(u);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
    /*
    @funkcja do usuwania uzytkownikow
    */
    public void deleteUser() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("user.odb");
        EntityManager em = emf.createEntityManager();
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Podaj id ktorego uzytkownika chcesz usunac: ");
        long id = in.nextLong();
        try{
            User user = em.find(User.class, id);
            em.getTransaction().begin();
            if(user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }
    }

}
