public class Payslip {
    private String name;
    private String iban;
    private String bic;
    private double rate;
    private double overtime;
    private double overtimePay;
    private double normalPay;
    private double totalPay;

    private String iD;

    public Payslip(String payslipName, String payslipIban, String payslipBic, double payslipRate, double payslipOvertime,
                   double payslipOvertimePay, double payslipNormalPay, double payslipTotalPay, String payslipID) {

            setWorkerDetails(payslipName);
            setWorkerDetails(payslipIban);
            setWorkerDetails(payslipBic);
            setWorkerDetails(payslipIban);
            setWorkerDetails(payslipRate);
            setWorkerDetails(payslipOvertime);
            setWorkerDetails(payslipOvertimePay);
            setWorkerDetails(payslipNormalPay);
            setWorkerDetails(payslipTotalPay);

            setWorkerID(payslipID);
    }
}
