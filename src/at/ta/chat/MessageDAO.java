package at.ta.chat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    List<UserVO> userVOList = new ArrayList<>();

    public List<UserVO> getAllUser() {

        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/chat?user=root";
            //Verbindung zur Datenbank
            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");

            //Statment für MYSQL befehl
            String sql = "Select * from chatuser";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //einzelne Zeilen ausgabe
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("userName");

                UserVO userVO = new UserVO(id, name);
                userVOList.add(userVO);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userVOList;
    }

    public void insertUser(UserVO userVO) {
        String sql = "INSERT INTO `chatuser`( `userName` ) VALUES ('" + userVO.getUserName() + "')";

        try {
            String url = "jdbc:mysql://localhost:3306/chat?user=root";
            //Verbindung zur Datenbank
            Connection connection = DriverManager.getConnection(url);
//            System.out.println("Connectet to DB!");

            Statement statement = connection.createStatement();
            statement.execute(sql);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public List<MessageVO> getChat() {
        List<MessageVO> MessageVOS = new ArrayList<>();
        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/chat?user=root";

            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");

            String sql = "Select * from chattable";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);


            while (rs.next()) {
                int id = rs.getInt("id");
                String created_at = rs.getDate("created_at").toString();
                String chat_text = rs.getString("chat_text");
                int fkName = rs.getInt("fk_user");
                System.out.println(id + " " + created_at + " " + chat_text + " " + fkName);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return MessageVOS;
    }

    public void insertMessage(String chatText, UserVO userVO) {

        String sql = "INSERT INTO `chattable`( `chat_text`, `fk_user`) VALUES ('" + chatText + "'," + userVO.getId() + ")";

        try {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/chat?user=root";
            //Verbindung zur Datenbank
            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");


            Statement statement = connection.createStatement();
            statement.execute(sql);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


}
