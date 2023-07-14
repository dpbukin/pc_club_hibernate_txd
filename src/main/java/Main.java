import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ComputerClub.class)
                .addAnnotatedClass(Computer.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Human.class)
                .addAnnotatedClass(Subscription.class)
                .buildSessionFactory();

        boolean exit = false;
        Session session = null;
        while (!exit) {
            System.out.println("Выбрать запрос:");
            System.out.println("1: Запрос на поиск информации из таблицы компьютерный клуб для поиска клубов в городе n");
            System.out.println("2: Запрос на поиск клиентов и абонементов, которые оформили клиенты с id от n до m");
            System.out.println("3: Запрос на поиск компьютерных клубов по id оформленных там аренд и id сотрудника оформившего аренду с должностью n");
            System.out.println("4: Запрос на поиск абонементов и связанных данных о клиенте, компьютерном клубе и сотруднике");
            System.out.println("5: Запрос на подсчет общего количества аренд для каждого клиента");
            System.out.println("6: Запрос на вычисление средней стоимости абонемента для каждого сотрудника");
            System.out.println("7: Запрос на поиск клиентов с максимальной общей стоимостью абонемента");
            System.out.println("8: Запрос на поиск компьютеров по стоимости аренды на них где cost больше n:");
            System.out.println("9: Запрос на поиск абонементов, оформленных сотрудником с должностью равной n:");
            System.out.println("10: Изменение почты у человека по id");
            System.out.println("11: Создание новой точки компьютерного клуба");
            System.out.println("12: Удаление записи о компьютерном клубе по id");
            System.out.println("0: Выход");
            System.out.print("Наш выбор: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    exit = true;
                    break;

                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Напишите по какому городу вы хотите искать компьютерные клубы: ");

                    String gorog = scanner1.next();

                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    List<ComputerClub> computerClubs = session.createQuery("FROM ComputerClub cc " +
                                    "WHERE cc.city = :city")
                            .setParameter("city" , gorog)
                            .getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");
                    System.out.print("Компьютерные клубы в городе " + gorog);

                    if (computerClubs.isEmpty()) {
                        System.out.println(" не найдены");
                    } else {
                        System.out.println(" найдены");
                        System.out.println("-------------------------------Список------------------------------------");
                        for (ComputerClub x : computerClubs) {
                            System.out.println("Компьютерный клуб: " + x);
                            System.out.println("-------------------------------------------------------------------------");
                        }
                    }

                    session.getTransaction().commit();


                    break;


                case 2:

                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Scanner scanner3 = new Scanner(System.in);

                    System.out.print("Введите начальное значение id для BETWEEN: ");
                    int startValue = scanner3.nextInt();

                    System.out.print("Введите конечное значение id для BETWEEN: ");
                    int endValue = scanner3.nextInt();

                    String hql = "SELECT c as client, s as subscription " +
                            "FROM Client c " +
                            "JOIN c.subscriptions s " +
                            "WHERE c.clientId " +
                            "BETWEEN :startValue AND :endValue";

                    List<Tuple> results = session.createQuery(hql, Tuple.class)
                            .setParameter("startValue", startValue)
                            .setParameter("endValue", endValue)
                            .getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    for (Tuple result : results) {
                        Client client = (Client) result.get(0);
                        Subscription subscription = (Subscription) result.get(1);

                        System.out.println("Информация о клиенте: " + client);
                        System.out.println("Информация об аренде: " + subscription);
                        System.out.println("-------------------------------------------------------------------------");
                    }

                    session.getTransaction().commit();

                    break;


                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("Напишите по какой должности сотрудника искать записи: ");

                    String position = scanner2.next();

                    session = factory.getCurrentSession();
                    session.beginTransaction();


                    String hql3 = "SELECT cc, s.subscriptionId, e.employeeId " +
                            "FROM ComputerClub cc " +
                            "JOIN cc.subscriptions s " +
                            "JOIN s.employee e " +
                            "WHERE e.position = :position";

                    List<Tuple> results3 = session.createQuery(hql3, Tuple.class)
                            .setParameter("position", position)
                            .getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    if (results3.isEmpty()) {
                        System.out.println("Записи не найдены или неправильно введена должность");
                    } else {
                        System.out.println("Записи найдены");
                        System.out.println("-------------------------------Список------------------------------------");

                        for (Tuple result : results3) {
                            ComputerClub computerClub = (ComputerClub) result.get(0);
                            int subscriptionId = (int) result.get(1);
                            int employeeId = (int) result.get(2);

                            System.out.println("Информация о клубе: " + computerClub);
                            System.out.println("Информация об аренде: " + subscriptionId);
                            System.out.println("Информация о сотруднике: " + employeeId);

                            System.out.println("-------------------------------------------------------------------------");
                            // Дальнейшая обработка результатов
                        }
                    }

                    session.getTransaction().commit();

                    break;

                case 4:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    String hql4 = "SELECT s.subscriptionId, s.uniqueSubscriptionNumber, c, cc, e FROM Subscription s JOIN s.client c JOIN s.computerClub cc JOIN s.employee e";

                    List<Tuple> results4 = session.createQuery(hql4, Tuple.class).getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    for (Tuple result : results4) {
                        Integer subscriptionId = (Integer) result.get(0);
                        String uniqueSubscriptionNumber = (String) result.get(1);
                        Client client = (Client) result.get(2);
                        ComputerClub computerClub = (ComputerClub) result.get(3);
                        Employee employee = (Employee) result.get(4);

                        System.out.println("Записи:");
                        System.out.println("id аренды: " + subscriptionId);
                        System.out.println("Уникальный номер аренды: " + uniqueSubscriptionNumber);
                        System.out.println("Информация о клиенте: " + client);
                        System.out.println("Информация о компьютере: " + computerClub);
                        System.out.println("Информация о сотруднике: " + employee);
                        System.out.println("-------------------------------------------------------------------------");

                        // Дальнейшая обработка результатов
                    }


                    session.getTransaction().commit();

                    break;

                case 5:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    String hql5 = "SELECT c.clientId, COUNT(s.subscriptionId) AS totalRentals FROM Client c JOIN c.subscriptions s GROUP BY c.clientId";

                    List<Tuple> results5 = session.createQuery(hql5, Tuple.class).getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    for (Tuple result : results5) {
                        Integer clientId = (Integer) result.get(0);
                        Long totalRentals = (Long) result.get(1);

                        System.out.println("id клиента : " + clientId);
                        System.out.println("Количество абонементов офрмленных клиентом: " + totalRentals);
                        System.out.println("-------------------------------------------------------------------------");

                        // Дальнейшая обработка результатов
                    }


                    session.getTransaction().commit();

                    break;

                case 6:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    String hql6 = "SELECT e.employeeId, ROUND(AVG(s.cost), 2) AS average_cost FROM Employee e JOIN e.subscriptions s GROUP BY e.employeeId";
                    List<Tuple> results6 = session.createQuery(hql6, Tuple.class).getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    for (Tuple result : results6) {
                        Integer employeeId = (Integer) result.get(0);
                        Double averageCost = (Double) result.get(1);

                        System.out.println("id сотрудника: " + employeeId);
                        System.out.println("Средняя стоимость абонемента, оформленная сотрудником: " + averageCost);
                        System.out.println("-------------------------------------------------------------------------");
                    }
                    session.getTransaction().commit();


                    break;


                case 7:
                    session = factory.getCurrentSession();
                    session.beginTransaction();


                    String hql7 = "SELECT c.clientId, SUM(s.cost) AS totalCost FROM Client c JOIN c.subscriptions s GROUP BY c.clientId ORDER BY totalCost DESC";

                    List<Tuple> results7 = session.createQuery(hql7, Tuple.class).getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    for (Tuple result : results7) {
                        Integer clientId = (Integer) result.get(0);
                        Long totalCost = (Long) result.get(1);



                        System.out.println("id клиента: " + clientId);
                        System.out.println("Максимальная стоимость его абонемента: " + totalCost);
                        System.out.println("-------------------------------------------------------------------------");
                        // Дальнейшая обработка результатов
                    }


                    session.getTransaction().commit();

                    break;

                case 8:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Scanner scanner4 = new Scanner(System.in);
                    System.out.print("Напишите выше какой стоимости будут искаться записи: ");
                    int cost = scanner4.nextInt();

                    System.out.println();


                    String hql8 = "SELECT c FROM Computer c " +
                            "WHERE c.computerId IN " +
                            "(SELECT s.computer.computerId " +
                            "FROM Subscription s " +
                            "WHERE s.cost > :cost)";

                    List<Computer> computers = session.createQuery(hql8, Computer.class)
                            .setParameter("cost", cost)
                            .getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    if (computers.isEmpty()) {
                        System.out.println("Записи не найдены, попробуйте ввести число поменьше");
                    } else {
                        System.out.println("Записи найдены");
                        System.out.println("-------------------------------Список------------------------------------");
                        for (Computer computer : computers) {
                            // Обработка каждого компьютера
                            System.out.println("Computer ID: " + computer.getComputerId());
                            System.out.println("Serial Number: " + computer.getSerialNumber());
                            System.out.println("Processor Model: " + computer.getProcessorModel());
                            System.out.println("RAM Capacity: " + computer.getRamCapacity());
                            // Другие поля компьютера

                            System.out.println("-------------------------------------------------------------------------");
                        }
                    }

                    session.getTransaction().commit();

                    break;


                case 9:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Scanner scanner5 = new Scanner(System.in);
                    System.out.print("Напишите по какой должности сотрудника искать записи: ");

                    String position1 = scanner5.next();

                    String hql9 = "SELECT s FROM Subscription s WHERE EXISTS " +
                            "(SELECT e FROM Employee e WHERE e.position = :position)";

                    List<Subscription> results9 = session.createQuery(hql9, Subscription.class)
                            .setParameter("position", position1)
                            .getResultList();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    if (results9.isEmpty()) {
                        System.out.println("Записи не найдены, попробуйте написать другою должность");
                    } else {
                        System.out.println("Записи найдены");
                        System.out.println("-------------------------------Список------------------------------------");

                        for (Subscription subscription : results9) {
                            // Обработка каждого объекта Subscription
                            System.out.println("Subscription ID: " + subscription.getSubscriptionId());
                            System.out.println("Type: " + subscription.getType());
                            // Другие свойства Subscription

                            Employee employee = subscription.getEmployee();
                            System.out.println("Employee ID: " + employee.getEmployeeId());
                            System.out.println("Name: " + employee.getHumanInfo());

                            System.out.println("-------------------------------------------------------------------------");
                        }
                    }

                    session.getTransaction().commit();

                    break;

                case 10:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Scanner scanner6 = new Scanner(System.in);
                    System.out.print("Напишите id Human-a у которого меняем email: ");
                    int id = scanner6.nextInt();

                    System.out.print("Напишите email на который меняем: ");
                    String email1 = scanner6.next();

                    System.out.println();
                    Human human = session.get(Human.class, id);
                    System.out.println("Human до изменения почты");
                    System.out.println(human);

                    String hql10 = "UPDATE Human SET email = :newEmail WHERE humanId = :id";
                    Query query = (Query) session.createQuery(hql10)
                            .setParameter("newEmail", email1)
                            .setParameter("id", id);

                    int rowsAffected = query.executeUpdate();

                    System.out.println("-----------------------------Результат запроса---------------------------");
                    if (rowsAffected > 0) {

                        System.out.println("Почта успешно изменена.");
                    } else {
                        System.out.println("Не удалось изменить почту.");
                    }


                    session.getTransaction().commit();

                    System.out.println();
                    System.out.println("Human до изменения почты");
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Human human1 = session.get(Human.class, id);
                    System.out.println(human1);

                    break;


                case 11:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Scanner scanner7 = new Scanner(System.in);

                    System.out.println("Введите значения в поля ниже, для добавления новой записи");

                    System.out.print("Номер аренды помещения: ");
                    String roomRentalAgreement = scanner7.next();

                    System.out.print("Область: ");
                    String region = scanner7.next();

                    System.out.print("Город: ");
                    String city = scanner7.next();

                    System.out.print("Улица: ");
                    String street = scanner7.next();

                    System.out.print("Строение: ");
                    int building = scanner7.nextInt();

                    System.out.print("Статус работы: ");
                    String jobStatus = scanner7.next();

                    System.out.print("Номер офиса: ");
                    int officeNumber = scanner7.nextInt();

                    // Создание новой точки компьютерного клуба
                    ComputerClub newClub = new ComputerClub();
                    newClub.setRoomRentalAgreementNumber(roomRentalAgreement);
                    newClub.setRegion(region);
                    newClub.setCity(city);
                    newClub.setStreet(street);
                    newClub.setBuilding(building);
                    newClub.setJobStatus(jobStatus);
                    newClub.setOfficeNumber(officeNumber);

                    // Сохранение новой точки компьютерного клуба в базе данных
                    session.save(newClub);

                    int clubId = newClub.getClubId();

                    session.getTransaction().commit();

                    System.out.println("-----------------------------Результат запроса---------------------------");


                    // Получение информации о новой точке компьютерного клуба
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    System.out.println("Запись из таблицы добавленненого клуба");
                    ComputerClub computerClub1 = session.get(ComputerClub.class, clubId);
                    System.out.println(computerClub1);
                    session.getTransaction().commit();

                    break;



                case 12:
                    session = factory.getCurrentSession();
                    session.beginTransaction();

                    Scanner scanner8 = new Scanner(System.in);

                    System.out.print("Введите id клуба о котором удалить запись: ");
                    int ide = scanner8.nextInt();

                    System.out.println("-----------------------------Результат запроса---------------------------");

                    ComputerClub computerClub = session.get(ComputerClub.class, ide);
                    session.delete(computerClub);

                    System.out.println("Запись о клубе стерта из базы данных");

                    session.getTransaction().commit();

                    break;

            }


        }factory.close();
    }
}
