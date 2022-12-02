package Creation;

public class CreateWorker {
    private String name;
    private String iban;
    private String bic;
    private double rate;

    public CreateWorker(String workerName, String workerIban, String workerBic, double workerRate) {
        setName(workerName);
        setBic(workerBic);
        setRate(workerRate);
        setIban(workerIban);
    }
    public String getName() {
        return name;
    }

    public void setName(String wname) {
        if(wname.length() > 3){
            name = wname;
        }
        else{
            throw new IllegalArgumentException("This is not a valid name must be 3 or more characters"); // Outputs an error
        }
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String wiban) {
        if(wiban.length() == 22){
            iban = wiban;
        }
        else{
            throw new IllegalArgumentException("This is not a valid iban"); // Outputs an error
        }
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String wbic) {
        if (wbic.length() > 8) {
            bic = wbic;
        } else {
            throw new IllegalArgumentException("This is not a valid bic"); // Outputs an error
        }
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double wrate) {
        if(wrate >= 10.50){
            rate = wrate;
        }
        else{
            throw new IllegalArgumentException("This is not a rate"); // Outputs an error
        }
    }
}
