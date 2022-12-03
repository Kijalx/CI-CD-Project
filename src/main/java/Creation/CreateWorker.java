package Creation;

import org.springframework.data.annotation.LastModifiedBy;

//Need to make an email field for Eoins part
public class CreateWorker {
    private String firstName;
    private String lastName;
    private String iban;
    private String bic;
    private int rate;
    private String email;

    public CreateWorker(String workerFirstName, String workerLastName, String workerIban, String workerBic, int workerRate, String email) {
        setFirstName(workerFirstName);
        setLastName(workerLastName);
        setBic(workerBic);
        setRate(workerRate);
        setIban(workerIban);
        setEmail(email);
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String wemail) {
        if(wemail.contains("@") == true){
            email = wemail;
        }
        else{
            throw new IllegalArgumentException("This is not a valid email must include @"); // Outputs an error
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String wFirstName) {
        if(wFirstName.length() > 3){
            firstName = wFirstName;
        }
        else{
            throw new IllegalArgumentException("This is not a valid name must be 3 or more characters"); // Outputs an error
        }
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String wLastName) {
        if(wLastName.length() > 3){
            lastName = wLastName;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int wrate) {
        if(wrate >= 10){
            rate = wrate;
        }
        else{
            throw new IllegalArgumentException("This is not a rate"); // Outputs an error
        }
    }
}
