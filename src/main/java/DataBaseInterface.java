import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseInterface extends DataBaseMethods {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apartments?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Area51appdata2003";

    static Connection conn;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            try {
                conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                initDB();

                while (true) {
                    System.out.println("Enter you choose:");
                    System.out.println("\t1: add new client");
                    System.out.println("\t2: add new good");
                    System.out.println("\t3: add new order");
                    System.out.print("->");

                    String s = scanner.nextLine();
                    switch (s) {
                        case "1" -> newClient(scanner);
                        case "2" -> newGood(scanner);
                        case "3" -> newOrder(scanner);
                        default -> {return;}
                    }
                }

            } finally {
                scanner.close();
                if (conn != null) conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}