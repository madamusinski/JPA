import model.DBLogic;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        DBLogic db = new DBLogic();
        for (;;) {

            System.out.println("Witaj w niezwykle prostej bazie danych.");
            System.out.println("\t==== M.E.N.U ====");
            System.out.println("1. Utworz rekord");
            System.out.println("2. Wyswietl wszystkich użytkowników");
            System.out.println("3. Wyświetl tylko nazwiska");
            System.out.println("4. Wyświetl tylko nazwe uzytkownika");
            System.out.println("5. Znajdz użytkownika po ID");
            System.out.println("6. Znajdz użytkownika po imieniu");
            System.out.println("7. Znajdz użytkownika po nazwisku");
            System.out.println("8. Usun rekord w bazie");
            System.out.println("9. Zlicz użytkowników");
            System.out.println("10. WYJDŹ Z PROGRAMU");
            System.out.println("\n Wprowadz opcje: ");

            switch (scanner.nextInt()) {

                // TODO: Utworz rekord
                case 1: {
                    db.addUser();
                    break;
                }

                // TODO: wyswietl rekordy
                case 2: {
                    System.out.println("\n\n");
                    db.viewUsers();
                    System.out.println("Press Enter key to continue...");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }

                    break;
                }

                // TODO:wyswietl wszystkie nazwiska
                case 3: {
                    db.viewUserSurnames();
                    System.out.println("Press Enter key to continue...");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }
                    break;
                }

                // TODO:wyswietl wszystkie pełne nazwy użytkowników
                case 4: {
                    db.viewUserNames();
                    System.out.println("Press Enter key to continue...");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }
                    break;
                }

                // TODO: Znajdz uzytkownika po ID
                case 5: {
                    db.searchUserByID();
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }
                    break;
                }

                // TODO: Znajdz rekord po imieniu
                case 6: {
                    db.searchUserByName();
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }
                    break;
                }

                // TODO: Znajdz rekord po nazwisku
                case 7: {
                    db.searchUserBySurname();
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }
                    break;
                }



                // TODO: usun rekord w bazie
                case 8: {
                    db.deleteUser();
                    break;
                }

                // TODO: zlicz userow
                case 9: {
                    db.countUsers();
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error " + e);
                    }
                    break;
                }

                case 10: {
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Wprowadz prawidlowa wartosc.");
                }
            }

        }


//        try {
//            // Obtain a database connection:
//            Properties properties = new Properties();
//            properties.setProperty(
//                    "javax.jdo.PersistenceManagerFactoryClass",
//                    "com.objectdb.jdo.PMF");
//            properties.setProperty(
//                    "javax.jdo.option.ConnectionURL", "user.odb");
//            PersistenceManagerFactory pmf =
//                    JDOHelper.getPersistenceManagerFactory(properties);
//            PersistenceManager pm = pmf.getPersistenceManager();
//
//            try {
//                // Begin the transaction:
//                pm.currentTransaction().begin();
//
//                AccountLogger accountLogger = new AccountLogger(new Date(), new Date(), "Cracow");
//                Salary salary = new Salary(45, 450000, new Date());
//                PhoneDetails phoneDetails = new PhoneDetails("office", 473222112, "t-mobile");
//
//                // Create and store a new User instance:
//                UserDetails userDetails = new UserDetails.Builder()
//                        .phone("3248232222")
//                        .nickName("Testowiron")
//                        .city("Kraków")
//                        .birthDay(21)
//                        .birthMonth(5)
//                        .birthYear(1993)
//                        .zipCode("44-335")
//                        .avatar("http://www.google.pl/img/testowiron34")
//                        .build();
//
//                User user = new User("testowy1234@gmail.com", "Test3", "Testowy3", 24, true, true, userDetails, accountLogger, salary, phoneDetails);
//                pm.makePersistent(user);
//
//                // Print all the Persons in the database:
////                Extent extent = pm.getExtent(User.class, false);
////                for (Object anExtent : extent) System.out.println(anExtent);
////                extent.closeAll();
//
//                // Commit the transaction:
//                pm.currentTransaction().commit();
//
//
////                EntityManagerFactory emf =
////                        Persistence.createEntityManagerFactory("user.odb");
////                EntityManager em = emf.createEntityManager();
////                TypedQuery<User> query =
////                        em.createQuery("SELECT COUNT(p) FROM User p", User.class);
////                System.out.println("User quantity: " + query.getSingleResult());
//
//                EntityManagerFactory emf =
//                        Persistence.createEntityManagerFactory("user.odb");
//                EntityManager em = emf.createEntityManager();
//                TypedQuery<User> query =
//                        em.createQuery("SELECT u FROM User u", User.class);
//                List<User> results = query.getResultList();
//                for (User u : results) {
//                    System.out.println(u);
//                }
//
//            }
//            finally {
//                // Close the database and active transaction:
//                if (pm.currentTransaction().isActive())
//                    pm.currentTransaction().rollback();
//                if (!pm.isClosed())
//                    pm.close();
//            }
//        }
//
//        // Handle both JDOException and NumberFormatException:
//        catch (RuntimeException x) {
//            System.err.println("Error: " + x.getMessage());
//
//        }
    }
}
