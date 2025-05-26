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

private Connection conexion;

    public CryptoHistoricalPriceDAO() {
        conexion = Conexion.getConnection();  // Usando tu clase existente de conexión
    }

    public void insertar(CryptoHistoricalPrice price) throws SQLException {
        String sql = "INSERT INTO CryptoHistoricalPrices (symbol, date, close_price) VALUES (?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, price.getSymbol());
        ps.setDate(2, new java.sql.Date(price.getDate().getTime()));
        ps.setDouble(3, price.getClosePrice());
        ps.executeUpdate();
    }

    public List<Date> obtenerFechasCargadas(String symbol) throws SQLException {
        List<Date> fechas = new ArrayList<>();
        String sql = "SELECT date FROM CryptoHistoricalPrices WHERE symbol = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, symbol);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            fechas.add(rs.getDate("date"));
        }
        return fechas;
    }

}
