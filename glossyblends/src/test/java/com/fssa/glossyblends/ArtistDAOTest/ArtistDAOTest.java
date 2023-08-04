package com.fssa.glossyblends.ArtistDAOTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.model.Artist.Artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArtistDAOTest {

    private static Connection connection;
    private static ArtistDAO artistDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws SQLException {
        // Set up the database connection once before running the test cases
        String dbURL = "jdbc:mysql://localhost:3306/Glossy_Blends_Artist";
        String username = "root";
        String password = "123456";
        connection = DriverManager.getConnection(dbURL, username, password);
        artistDAO = new ArtistDAO(connection);
    }

    @AfterClass
    public static void tearDownAfterClass() throws SQLException {
        // Close the database connection once all the test cases are executed
        if (connection != null) {
            connection.close();
        }
    }

    private Artist createMockArtist( String username, String password, String email,
            String phone, int yearsOfExperience, boolean isAvailable,
            String location, String languagesSpoken, Artist.gender gender,
            double averageRating) {
Artist artist = new Artist();
//artist.setArtistId(artistId);
artist.setUsername(username);
artist.setPassword(password);
artist.setEmail(email);
artist.setPhone_number(phone);
artist.setYearsOfExperience(yearsOfExperience);
artist.setAvailable(isAvailable);
artist.setLocation(location);
artist.setLanguagesSpoken(languagesSpoken);
artist.setGenderOfArtist(gender);
artist.setAverageRating(averageRating);
return artist;
}

@Test
public void testAddArtist_ValidArtist_Success() throws PostValueInvalidException, ServiceValueInvalidException {
// Test case for adding a valid artist
Artist artist = createMockArtist( "JohnDoe", "Password123", "johndoe@example.com",
"1234567890", 5, true, "chennai", "English, Spanish", Artist.gender.MALE, 4.5);

// Save the initial number of rows in the artists table
int initialRowCount = getRowCount("artists");

boolean result = artistDAO.addArtist(artist);

// Save the final number of rows in the artists table after adding the artist
int finalRowCount = getRowCount("artists");

assertTrue(result);
assertEquals(initialRowCount + 1, finalRowCount);
}





//@Test
//public void testDeleteArtist_ValidArtist_Success() {
//// Test case for deleting a valid artist
//Artist artist = createMockArtist( "JohnDoe", "Password123", "johndoe@example.com",
//"+1234567890", 5, true, "New York", "English, Spanish", Artist.gender.MALE, 4.5);
//artistDAO.addArtist(artist);
//
//// Save the initial number of rows in the artists table
//int initialRowCount = getRowCount("artists");
//
//boolean result = artistDAO.deleteArtist(String.valueOf(artist.getArtistId()));
//
//// Save the final number of rows in the artists table after deleting the artist
//int finalRowCount = getRowCount("artists");
//
//assertTrue(result);
//assertEquals(initialRowCount - 1, finalRowCount);
//}







// Helper method to get the number of rows in a specific table

private int getRowCount(String tableName) {
try {
String query = "SELECT COUNT(*) FROM " + tableName;
PreparedStatement stmt = connection.prepareStatement(query);
ResultSet resultSet = stmt.executeQuery();

if (resultSet.next()) {
return resultSet.getInt(1);
}

resultSet.close();
stmt.close();
} catch (SQLException e) {
e.printStackTrace();
}

return -1;
}
}
