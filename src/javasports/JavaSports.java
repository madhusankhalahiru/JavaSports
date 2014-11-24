package javasports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javasports.SerializeToDatabase.RetriveObjectFromDb;
import static javasports.SerializeToDatabase.EnterObjectToDataBase;

public class JavaSports {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner input = new Scanner(System.in);
        Connection connection = null;
       long id = 3 ;

        String driver = "com.mysql.jdbc.Driver";            // connecting to database
        String url = "jdbc:mysql://localhost/sports";
        String username = "root";                           // connecting to root
        String password = "";
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        PremierLeagueManager obj = new PremierLeagueManager();

        boolean done = false;
        while (done != true) {
            System.out.println("");
            System.out.println("User Menu");
            System.out.println("**********");
            System.out.println("1) Add to premier league");
            System.out.println("2) Show detail about clubs");       // print menu using switch cases
            System.out.println("3) Delete the record");             
            System.out.println("4) Update the records");
            System.out.println("5) Calender");
            System.out.println("6) Exit");
            System.out.println("");
            System.out.print("Enter your choice : ");

            int menu = input.nextInt();
            switch (menu) {
                case 1:
                     id =  obj.addToPL(connection);         
                    
                    break;

                case 2:
                    System.out.println("Enter your choice");
                    System.out.println("");
                    System.out.println("1) Search by ID   :");
                    System.out.println("2) Search by name :");
                     System.out.println("3) Decending Order");
                    System.out.println("4) Back :");

                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the club id of which informations are needed : ");
                            int num = input.nextInt();
                            obj.showDetail(connection, num);
                            break;
                        case 2:
                            System.out.println("Enter the club name of which informations are needed : ");
                            String name = input.next();
                            try {
                                for (int i = 1; i <= id; i++) {
                                    obj.showDetail2(connection, i, name);
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            System.out.println("Decending order");
                            obj.ShowDetailsDec(connection, id);
                        case 4:
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Enter name of club of which record should be deleted :");
                    String name = input.next();
                    try {
                        for (int i = 1; i < id; i++) {
                            obj.deleteRecord(connection, i, name);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.println("Enter the record which you want to change :");
                    String name1 = input.next();
                    System.out.println("Enter the current value add to score ");
                    int num = input.nextInt();
                    try {
                        for (int i = 1; i < id; i++) {
                            obj.updateRecord(connection, i, name1, num);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    calender obj2 = new calender();
                    System.out.println("Enter the Year :");
                    int year = input.nextInt();
                    System.out.println("Enter the Month :");
                    int month = input.nextInt();
                    obj2.printMonth(year, month);

                    System.out.println("1) Add reminder   ");
                    System.out.println("2) Show reminders ");
                    System.out.println("3) Exit ");
                    System.out.println("Enter what is needed :");
                    int need = input.nextInt();

                    switch (need) {
                        case 1:
                            try {
                                System.out.println("Enter the date :");
                                int date = input.nextInt();
                                String search = year + "" + month + "" + date;
                                int searchrem = Integer.parseInt("search");
                                System.out.println("Enter the message :");
                                String message = input.next();
                                obj2.setReminder(searchrem, message);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("Enter the date :");
                            int date1 = input.nextInt();
                            String search1 = year + "" + month + "" + date1;
                            int searchrem1 = Integer.parseInt("search");
                            //obj2.getReminder(searchrem1);
                    }
                
                case 6:
                    done = true;
            }
        }
    }

}
