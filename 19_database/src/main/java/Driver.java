

import java.sql.*;
import java.util.LinkedList;


public class Driver {
    public static void main(String[] args) {
        //  DB_URL
        //  DB_PORT
        //  DB_NAME
        //  DB_USERNAME
        //  DB_PASSWORD
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = String.format("jdbc:mysql://%s:%s/%s",
                    System.getenv("DB_URL"),
                    System.getenv("DB_PORT"),
                    System.getenv("DB_NAME"));

            String username = System.getenv("DB_USERNAME");
            String password = System.getenv("DB_PASSWORD");

            // Socket
            Connection connection = DriverManager.getConnection(url, username, password);

            // Request
            Statement statement = connection.createStatement();

            // send
            String query = "SELECT * FROM coupons";
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.println(metaData.getColumnName(i + 1));
            }
            // Response

//            {
//                resultSet.next();
//                String name = resultSet.getString("name");
//                System.out.println(name);
//            }
//
//            {
//                resultSet.next();
//                String name = resultSet.getString("name");
//                System.out.println(name);
//            }
//
//            {
//                resultSet.next();
//                String name = resultSet.getString("name");
//                System.out.println(name);
//            }

//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                System.out.println(name);
//            }

            LinkedList<Coupon> coupons = new LinkedList<>();
            while (resultSet.next()) {
                Coupon coupon = CouponORM.toObject(resultSet);
                coupons.add(coupon);
            }
            System.out.println(coupons);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}