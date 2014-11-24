

package javasports;

import java.sql.Connection;


public interface LeagueManager {            // this class also can't make object but in premier league class it implement
    long addToPL(Connection connection);    // this class and override these methods 
    void showDetail(Connection connection,long serialized_id);
    void showDetail2(Connection connection, long serialized_id,String searchName);
    void deleteRecord(Connection connection, long serialized_id, String searchName);
    void updateRecord(Connection connection, long serialized_id, String searchName, int score);
}
