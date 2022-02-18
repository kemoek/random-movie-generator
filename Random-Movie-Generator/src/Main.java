import java.sql.*;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/movies_project";
		String user = "postgres";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement s = conn.createStatement();	// to send sql queries to the db
		
		Random rand = new Random();	
		int x = rand.nextInt(251) + 1;			// generate random integers in range 1 to 250

		String query = String.format("SELECT * FROM movies WHERE ranking = %d",x);
		
		ResultSet r = s.executeQuery(query);
		
		while(r.next()) {
			String ranking = r.getString(1);	
			String title = r.getString(2);
			String year = r.getString(3);
			String runtime = r.getString(4);	
			String genre = r.getString(5);
			String rating = r.getString(6);
			String director = r.getString(7);
			
			System.out.println("Ranking: " + ranking);
			System.out.println("Title: " + title);
			System.out.println("Year: " + year);
			System.out.println("Runtime: " + runtime);
			System.out.println("Genre: " + genre);
			System.out.println("Rating: " + rating);
			System.out.println("Director: " + director);
			
		}
		s.close();
		conn.close();
	}
}
