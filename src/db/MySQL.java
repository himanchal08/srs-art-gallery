package src.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class MySQL {
    public final Connection connection;

    public MySQL() throws Exception, IOException {
        String url = "jdbc:mysql://localhost:3306/db";
        this.connection = DriverManager.getConnection(url, "root", "123456");

        this.readSchemaSQL();
    }

    void readSchemaSQL() throws Exception {
        FileReader fr = new FileReader("schema.sql");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            this.createTableFromString(line);
        }

        br.close();
    }

    private void createTableFromString(String schema) throws SQLException {
        PreparedStatement st = this.connection.prepareStatement(schema);
        st.execute();
    }

    public boolean checkUser(String username, String password) throws Exception {
        PreparedStatement st = this.connection.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
        st.setString(1, username);
        st.setString(2, password);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            return true;
        }
        return false;
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

    public void insertUsersTable(String username, String password) throws Exception {
        PreparedStatement st = connection.prepareStatement("INSERT INTO Users (Username, Password) VALUES (?, ?)");
        st.setString(1, username);
        st.setString(2, password);
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
}