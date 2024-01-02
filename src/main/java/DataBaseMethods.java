import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseMethods {
    protected static void initDB() throws SQLException {
        Statement statement = DataBaseInterface.conn.createStatement();
        try {
            statement.execute("USE orders");
        } finally {
            statement.close();
        }
    }

    protected static void newClient(Scanner scanner) throws SQLException{
        System.out.println("Enter client name:");
        String name = scanner.nextLine();
        System.out.println("Enter client surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter client age:");
        int age = scanner.nextInt();

        PreparedStatement ps = DataBaseInterface.conn.prepareStatement("INSERT INTO clients " +
                "(name, secondname, age)" +
                "VALUES (?, ?, ?)");

        try {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setInt(3, age);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    protected static void newGood(Scanner scanner) throws SQLException{
        System.out.println("Enter type of product:");
        String typeOfProduct = scanner.nextLine();
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        System.out.println("Enter consignment:");
        String consignment = scanner.nextLine();
        System.out.println("Enter batch of product:");
        int batchOfProduct = scanner.nextInt();

        PreparedStatement ps = DataBaseInterface.conn.prepareStatement("INSERT INTO goods" +
                "(type_of_product, product_name, consignment, batch_of_product)" +
                "VALUES (?, ?, ?, ?)");

        try {
            ps.setString(1, typeOfProduct);
            ps.setString(2, productName);
            ps.setString(3, consignment);
            ps.setInt(4, batchOfProduct);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    protected static void newOrder(Scanner scanner) throws SQLException {
        System.out.println("Enter client ID:");
        int clientId = scanner.nextInt();
        System.out.println("Enter good ID:");
        int goodId = scanner.nextInt();

        PreparedStatement ps = DataBaseInterface.conn.prepareStatement("INSERT INTO orders_table" +
                "(clientNO, goodNo)" +
                "values (?, ?)");

        try {
            ps.setInt(1, clientId);
            ps.setInt(2, goodId);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }
}
