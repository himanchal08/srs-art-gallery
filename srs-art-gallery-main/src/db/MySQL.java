package src.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {
    private Connection connection;

    MySQL() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db";
        this.connection = DriverManager.getConnection(url, "root", "Abhishek@1234");

        this.createTableFromString(this.readSchemaSQL());
    }

    String readSchemaSQL() throws IOException, FileNotFoundException {
        FileReader fr = new FileReader("schema.sql");
        BufferedReader br = new BufferedReader(fr);
        StringBuffer schema = new StringBuffer();
        String line;

        while ((line = br.readLine()) != null) {
            schema.append(line);
        }

        br.close();

        return schema.toString();
    }

    private void createTableFromString(String schema) throws SQLException {
        PreparedStatement st = connection.prepareStatement(schema);
        st.execute();
    }

    void insertArtistTable(int aID, String aName, String aBio, String aPtflio, String aContact) throws Exception {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Artists VALUES(?,?,?,?,?)");
        st.setInt(1, aID);
        st.setString(2, aName);
        st.setString(3, aBio);
        st.setString(4, aPtflio);
        st.setString(5, aContact);
        st.executeUpdate();
    }

    void insertArtworkTable(int artID, String artTitle, int aID, String artMedium, String artDimensions, String artDate,
            Double artPrice, String imgPath) throws Exception {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Artworks VALUES(?,?,?,?,?,?,?,?)");
        Date date = Date.valueOf(artDate);
        st.setInt(1, artID);
        st.setString(2, artTitle);
        st.setInt(3, aID);
        st.setString(4, artMedium);
        st.setString(5, artDimensions);
        st.setDate(6, date);
        st.setDouble(7, artPrice);
        st.setString(8, imgPath);
        st.executeUpdate();
    }

    void insertExhibitionsTable(int eID, String eTitle, String sDate, String eDate) throws Exception {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Exhibitions VALUES(?,?,?,?)");
        Date sdate = Date.valueOf(sDate);
        Date edate = Date.valueOf(eDate);
        st.setInt(1, eID);
        st.setString(2, eTitle);
        st.setDate(3, sdate);
        st.setDate(4, edate);

        st.executeUpdate();
    }

    void insertUsersTable(int uID, String username, String upass, String role) throws Exception {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Users VALUES(?,?,?,?)");
        st.setInt(1, uID);
        st.setString(2, username);
        st.setString(3, upass);
        st.setString(4, role);
        st.executeUpdate();
    }

    void insertTransactionsTable(int tID, int userID, int aID, String sDate, double amount) throws Exception {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Transactions VALUES(?,?,?,?,?)");
        Date sdate = Date.valueOf(sDate);

        st.setInt(1, tID);
        st.setInt(2, userID);
        st.setInt(3, aID);
        st.setDate(4, sdate);
        st.setDouble(5, amount);
        st.executeUpdate();
    }

    void deleteUser(int userid) throws Exception {
        PreparedStatement st = connection.prepareStatement("DELETE FROM USERS WHERE userid = ?");
        st.setInt(1, userid);
        st.executeUpdate();
    }
}