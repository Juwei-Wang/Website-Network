import java.sql.ResultSet;
import java.sql.SQLException;

public class CouponORM {
    public static Coupon toObject(ResultSet resultSet) {
        Coupon coupon = new Coupon();
        try {
            coupon.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            coupon.setCode(resultSet.getString("code"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            coupon.setPercentage(resultSet.getInt("percentage"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coupon;
    }
}