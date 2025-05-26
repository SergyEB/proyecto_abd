package grupo05abd.modelo;

public class InvestmentExtraDetail {

private int extraDetailId;
    private int investmentId;
    private Integer termMonths;
    private String yieldFrequency;
    private Double minimumInvestment, additionalInvestment, minimumWithdrawal, pricePerShare, cryptoQuantity, unitPrice, propertyExpenses;
    private String penaltyDescription, cryptoName, propertyName;
    private Integer shares;

    // Constructor (completo)
    public InvestmentExtraDetail(int extraDetailId, int investmentId, Integer termMonths, String yieldFrequency,
        Double minimumInvestment, Double additionalInvestment, Double minimumWithdrawal, String penaltyDescription,
        Integer shares, Double pricePerShare, Double cryptoQuantity, String cryptoName, Double unitPrice,
        String propertyName, Double propertyExpenses) {
        this.extraDetailId = extraDetailId;
        this.investmentId = investmentId;
        this.termMonths = termMonths;
        this.yieldFrequency = yieldFrequency;
        this.minimumInvestment = minimumInvestment;
        this.additionalInvestment = additionalInvestment;
        this.minimumWithdrawal = minimumWithdrawal;
        this.penaltyDescription = penaltyDescription;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
        this.cryptoQuantity = cryptoQuantity;
        this.cryptoName = cryptoName;
        this.unitPrice = unitPrice;
        this.propertyName = propertyName;
        this.propertyExpenses = propertyExpenses;
    }

    public int getExtraDetailId() {
        return extraDetailId;
    }

    public void setExtraDetailId(int extraDetailId) {
        this.extraDetailId = extraDetailId;
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) {
        this.investmentId = investmentId;
    }

    public Integer getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }

    public String getYieldFrequency() {
        return yieldFrequency;
    }

    public void setYieldFrequency(String yieldFrequency) {
        this.yieldFrequency = yieldFrequency;
    }

    public Double getMinimumInvestment() {
        return minimumInvestment;
    }

    public void setMinimumInvestment(Double minimumInvestment) {
        this.minimumInvestment = minimumInvestment;
    }

    public Double getAdditionalInvestment() {
        return additionalInvestment;
    }

    public void setAdditionalInvestment(Double additionalInvestment) {
        this.additionalInvestment = additionalInvestment;
    }

    public Double getMinimumWithdrawal() {
        return minimumWithdrawal;
    }

    public void setMinimumWithdrawal(Double minimumWithdrawal) {
        this.minimumWithdrawal = minimumWithdrawal;
    }

    public Double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(Double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public Double getCryptoQuantity() {
        return cryptoQuantity;
    }

    public void setCryptoQuantity(Double cryptoQuantity) {
        this.cryptoQuantity = cryptoQuantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getPropertyExpenses() {
        return propertyExpenses;
    }

    public void setPropertyExpenses(Double propertyExpenses) {
        this.propertyExpenses = propertyExpenses;
    }

    public String getPenaltyDescription() {
        return penaltyDescription;
    }

    public void setPenaltyDescription(String penaltyDescription) {
        this.penaltyDescription = penaltyDescription;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    

}
