public class CreateWorker {
    private String name;
    private String iban;
    private String bic;
    private double hours;
    private double rate;
    private double overtimeHours;
    private double totalPay;
    private double normalPay;
    private double overtimePay;
    public CreateWorker(String name, String iban, String bic, double hours, double rate, double overtimeHours, double totalPay, double normalPay, double overtimePay) {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public double getNormalPay() {
        return normalPay;
    }

    public void setNormalPay(double normalPay) {
        this.normalPay = normalPay;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }
}
