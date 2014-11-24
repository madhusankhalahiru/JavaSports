package javasports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static javasports.SerializeToDatabase.RetriveObjectFromDb;
import static javasports.SerializeToDatabase.deleteJavaObjectFromDB;
import static javasports.SerializeToDatabase.EnterObjectToDataBase;
import static javasports.SerializeToDatabase.updateObjectFromDB;

public class PremierLeagueManager implements LeagueManager {

    @Override
    public long addToPL(Connection connection) {
        FootBallClub fbc = new FootBallClub();      // create foot ball club object
        fbc.createClub();                           // call to create club method

        long serialized_id = EnterObjectToDataBase(connection, fbc);    
        
        return serialized_id;
    }

    @Override
    public void showDetail(Connection connection, long serialized_id) {

        ArrayList<FootBallClub> objFromDatabase = new ArrayList<>();
        objFromDatabase.add(RetriveObjectFromDb(connection, serialized_id));    // use method in serializeToDatabase to 
                                                                                // deserialize
        for (FootBallClub object : objFromDatabase) {                           // go via the object and get values
            System.out.println("Club name      : " + object.getClubName());
            System.out.println("Club address   : " + object.getClubAddress());  // print items in object
            System.out.println("Current points : " + object.getCurrentPoint());
            System.out.println("Current Score  : " + object.getScore());
        }
    }

    @Override
    public void showDetail2(Connection connection, long serialized_id, String searchName) {

        ArrayList<FootBallClub> objFromDatabase = new ArrayList<>();
        objFromDatabase.add(RetriveObjectFromDb(connection, serialized_id));        // get name by parameter and search

        for (FootBallClub object : objFromDatabase) {
            if (object.getClubName().equals(searchName)) {
                System.out.println("Club name      : " + object.getClubName());
                System.out.println("Club address   : " + object.getScore());
                System.out.println("Current points : " + object.getCurrentPoint());
                System.out.println("Current Score  : " + object.getScore());
            }
        }
    }

    @Override
    public void deleteRecord(Connection connection, long serialized_id, String searchName) {

        ArrayList<FootBallClub> objFromDatabase = new ArrayList<>();
        objFromDatabase.add(RetriveObjectFromDb(connection, serialized_id));

        for (FootBallClub object : objFromDatabase) {
            if (object.getClubName().equals(searchName)) {
                deleteJavaObjectFromDB(connection, serialized_id);  // use deleteJavaObjectFromDB method in serializeToDatabase class
            }
        }
    }

    public void updateRecord(Connection connection, long serialized_id, String searchName, int score) {

        ArrayList<FootBallClub> objFromDatabase = new ArrayList<>();
        objFromDatabase.add(RetriveObjectFromDb(connection, serialized_id));

        for (FootBallClub object : objFromDatabase) {
            if (object.getClubName().equals(searchName)) {
                object.setScore(score);
                updateObjectFromDB(connection, serialized_id, object);
            }   
        }               // use updateObjectFromDB method in serializeToDatabase class
    }

    public void ShowDetailsDec(Connection connection, long serialized_id) {

       long index = serialized_id;
        ArrayList<FootBallClub> retriveObject = new ArrayList<>();
        
        for (int i = 0 ; i < index; i++) {      // use for loop to go throught objects
            
            System.out.println(serialized_id);
            retriveObject.add(RetriveObjectFromDb(connection, serialized_id));
            serialized_id-- ;   
        }    
        Collections.sort(retriveObject);

        for (FootBallClub object : retriveObject) {
            System.out.println("Club name      : " + object.getClubName());
            System.out.println("Club address   : " + object.getClubAddress());
            System.out.println("Current points : " + object.getCurrentPoint());
            System.out.println("Current Score  : " + object.getScore());
            System.out.println("");
        }
    }
}
