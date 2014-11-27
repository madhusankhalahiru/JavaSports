package javasports;

//import FootBallClub;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.*;


public class SerializeToDatabase {

    private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO sportsdata(serialized_object) VALUES (?)";
    private static final String SQL_DESERIALIZE_OBJECT = "SELECT serialized_object FROM sportsdata WHERE serialized_id = ?";
    private static final String SQL_DELETING_OBJECT = "DELETE FROM sportsdata WHERE serialized_id = ?";
    private static final String SQL_UPDATE_OBJECT = "UPDATE sportsdata SET serialized_object = ? WHERE serialized_id = ?";

    public static long EnterObjectToDataBase(Connection connection, FootBallClub objectToSerialize) {

        int serialized_id = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_SERIALIZE_OBJECT, Statement.RETURN_GENERATED_KEYS);

            ps.setObject(1, objectToSerialize);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                serialized_id = rs.getInt(1);
            }

            rs.close();
            ps.close();
            System.out.println("-------------------------------");
            System.out.println("|Java object saved successfully|");
            System.out.println("-------------------------------");
        } catch (Exception e) {
            System.out.println(e);
        }
        return serialized_id;
    }

    public static FootBallClub RetriveObjectFromDb(Connection connection, long serialized_id) {
        FootBallClub deSerializedObject = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL_DESERIALIZE_OBJECT);
            pstmt.setLong(1, serialized_id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            //Object object = rs.getObject(1);
            byte[] buf = rs.getBytes(1);
            ObjectInputStream objectIn = null;
            if (buf != null) {
                objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
            }

            deSerializedObject = (FootBallClub) objectIn.readObject();

            rs.close();
            pstmt.close();

            System.out.println("Retrive Object");
            System.out.println("==============");
        } catch (Exception e) {
            System.out.println(e);
        }
        return deSerializedObject;
    }

    public static Object deleteJavaObjectFromDB(Connection connection, long serialized_id) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL_DELETING_OBJECT);
            pstmt.setLong(1, serialized_id);
            pstmt.executeUpdate();
            System.out.println("Deleted successfully");
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return serialized_id;
    }

    public static Object updateObjectFromDB(Connection connection, long serialized_id, FootBallClub object) {

        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE_OBJECT);
            
            pstmt.setObject(1, object);
            pstmt.setLong(2, serialized_id);
            pstmt.executeUpdate();
            System.out.println("Updated successfully");
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return serialized_id;
    }
}