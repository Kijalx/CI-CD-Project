public class GetData implements Comparable<GetData> {
    private double name;
    private double iban;
    private double bic;
    private double hours;
    private double rate;
    private double overtimeHours;
    private double totalPay;
    private double normalPay;
    private double overtimePay;

    public double getName() {
        return name;
    }

    public void setName(double name) {
        this.name = name;
    }

    public double getIban() {
        return iban;
    }

    public void setIban(double iban) {
        this.iban = iban;
    }

    public double getBic() {
        return bic;
    }

    public void setBic(double bic) {
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



    public GetData(double name, double iban, double bic, double hours, double rate, double overtimeHours, double totalPay, double normalPay, double overtimePay) {
        this.name = name;
        this.iban = iban;
        this.bic = bic;
        this.hours = hours;
        this.rate = rate;
        this.overtimeHours = overtimeHours;
        this.totalPay = totalPay;
        this.normalPay = normalPay;
        this.overtimePay = overtimePay;
    }

    @Override
    public int compareTo(GetData o) {
        return 0;
    }
}
