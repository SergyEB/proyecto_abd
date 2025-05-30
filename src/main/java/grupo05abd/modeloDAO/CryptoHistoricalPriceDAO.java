package grupo05abd.modeloDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grupo05abd.conexion.Conexion;
import grupo05abd.modelo.CryptoHistoricalPrice;

public class CryptoHistoricalPriceDAO {

    public void insert(CryptoHistoricalPrice price) throws SQLException {
        String sql = "INSERT INTO CryptoHistoricalPrice (symbol, date, closePrice) VALUES (?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, price.getSymbol());
            ps.setDate(2, new java.sql.Date(price.getDate().getTime()));
            ps.setDouble(3, price.getClosePrice());
            ps.executeUpdate();
        }
    }

    public List<Date> getLoadedDates(String symbol) throws SQLException {
        List<Date> dates = new ArrayList<>();
        String sql = "SELECT date FROM CryptoHistoricalPrice WHERE symbol = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, symbol);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dates.add(rs.getDate("date"));
                }
            }
        }
        return dates;
    }

    public Date getLastLoadedDate(String symbol) throws SQLException {
        String sql = "SELECT MAX(date) AS lastDate FROM CryptoHistoricalPrice WHERE symbol = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, symbol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDate("lastDate");
                }
            }
        }
        return null;
    }
}
