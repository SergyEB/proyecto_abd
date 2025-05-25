package grupo05abd.modelo;

public class CurrencyType {

private int currencyTypeId;
    private String currencyName;
    private String symbol;       // Nullable
    private String isoCode;      // Nullable

    public CurrencyType(int currencyTypeId, String currencyName, String symbol, String isoCode) {
        this.currencyTypeId = currencyTypeId;
        this.currencyName = currencyName;
        this.symbol = symbol;
        this.isoCode = isoCode;
    }

    public int getCurrencyTypeId() {
        return currencyTypeId;
    }

    public void setCurrencyTypeId(int currencyTypeId) {
        this.currencyTypeId = currencyTypeId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }


}
