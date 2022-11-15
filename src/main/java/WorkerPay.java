public class WorkerPay {
    double hours;
    double rate;
    double overtime;
    double overtimePay;
    double normalPay;
    double totalPay;
    public WorkerPay(double hours, double rate){
        setHours(hours);
        setRate(rate);
        setOvertimePay();
        setNormalPay();
        setTotalPay();
    }
    public double getHours() {
        return hours;
    }

    public void setHours(double whours) {
        if(whours > 0 && whours <= 35){
            hours = whours;
            overtime = 0;
        }
        else if(whours > 35){
            overtime = whours - 35;
            hours = whours - overtime;
        }
        else{
            throw new IllegalArgumentException("This is not a valid amount of hours"); // Outputs an error
        }
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double wrate) {
        //need to get rate from databas
        if(wrate >= 10.5){
            rate = wrate;
        }
        else{
            throw new IllegalArgumentException("This is not a valid rate"); // Outputs an error
        }
    }

    public double getOvertime() {
        return overtime;
    }


    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay() {
        if(overtime > 0){
            overtimePay = overtime * (rate * 1.5);
        }
        else{
            overtimePay = 0;
        }
    }

    public double getNormalPay() {
        return normalPay;
    }

    public void setNormalPay() {
        //need to get id from dataBase
        //database.id.rate
        normalPay = hours * rate;
    }

    public double getTotalPay() {
        return totalPay;
    }
    public void setTotalPay(){
        if(overtimePay > 0){
            totalPay = normalPay + overtimePay;
        }
        else{
            totalPay = normalPay;
        }
    }
}
