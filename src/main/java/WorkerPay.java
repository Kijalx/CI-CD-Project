public class WorkerPay {
    double hours;
    double rate;
    double overtime;
    double overtimePay;
    double normalPay;
    public WorkerPay(double hours, double rate, double overtime){
        setHours(hours);
        setOvertime(overtime);
        setRate(rate);
        setOvertimePay();
        setNormalPay();
    }
    public double getHours() {
        return hours;
    }

    public void setHours(double whours) {
        if(whours > 0){
            hours = whours;
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
        if(wrate > 10.5 && wrate < 13.5){
            rate = wrate;
        }
        else{
            throw new IllegalArgumentException("This is not a valid rate"); // Outputs an error
        }
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double wovertime) {
        if(wovertime >= 0){
            overtime = wovertime;
        }
        else{
            throw new IllegalArgumentException("This is not a valid overtime"); // Outputs an error
        }
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay() {
        if(overtime > 0 && overtimePay < 3){
            overtimePay = overtime * (rate * 1.5);
        }
        else if (overtimePay > 3){
            overtimePay = overtime * (rate * 2);
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
        if(hours > 0){
            normalPay = hours * rate;
        }
        else{
            normalPay = 0;
        }
    }
}
