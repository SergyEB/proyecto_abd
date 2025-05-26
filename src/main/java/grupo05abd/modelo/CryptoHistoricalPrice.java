package grupo05abd.modelo;

import java.sql.Date;

public class CryptoHistoricalPrice {

    private int id;  // PK
    private String symbol;  // BTC, ETH, etc.
    private Date date;  // Fecha del precio
    private double closePrice;  // Precio de cierre

    // Constructor
    public CryptoHistoricalPrice(int id, String symbol, Date date, double closePrice) {
        this.id = id;
        this.symbol = symbol;
        this.date = date;
        this.closePrice = closePrice;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getClosePrice() { return closePrice; }
    public void setClosePrice(double closePrice) { this.closePrice = closePrice; }

}
