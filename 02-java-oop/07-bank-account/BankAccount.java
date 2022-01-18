public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    public static int numOfAccounts =0;
    public static double totalMoney =0;

    public BankAccount(){
        BankAccount.numOfAccounts+=1;
        this.checkingBalance =0;
        this.savingsBalance =0;

    }
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    public void depositMoney(String account, double amount){
        if (account == "savings") {
            // this.savingsBalance = this.savingsBalance+amount;
            this.savingsBalance +=amount;
            System.out.println("Savings balance: "+this.savingsBalance);
            System.out.println("$"+amount+" deposited in savings account");
        } else if(account =="checking") {
            // this.checkingBalance = this.checkingBalance+amount;
            this.checkingBalance += amount;
            System.out.println("Checking balance: "+this.checkingBalance);
            System.out.println("$"+amount+" deposited in checking account");
        } else{
            System.out.println("please choose savings or checking option");
        }
        // totalMoney = totalMoney+amount;
        BankAccount.totalMoney += amount;
    }
    public void withdrawMoney(String account, double amount){
        if(account == "savings"){
            if(this.savingsBalance- amount>= 0){
                // this.savingsBalance = this.savingsBalance-amount;
                this.savingsBalance -= amount;
                System.out.println("Savings balance: "+this.savingsBalance);
                System.out.println("$"+amount+" withdrawn from savings account");
                totalMoney = totalMoney-amount;
            } else{
                System.out.println("Insufficient funds in savings account");
            }
        }else if(account == "checking"){
            if(this.checkingBalance - amount >= 0){
                // this.checkingBalance = this.checkingBalance-amount;
                this.checkingBalance -= amount;
                System.out.println("Checking balance: "+this.checkingBalance);
                System.out.println("$"+amount+" withdrawn from checking account");
                totalMoney = totalMoney-amount;
            }else{
                System.out.println("Insufficient funds in savings account");
            }
        }else {
            System.out.println("please choose savings or checking option");
        }
    }
    public double totalAccountsBalance(){
        return checkingBalance+savingsBalance;
    }
    public void displayAccountBalance(){
        System.out.println(String.format("Savings: %.2f, Checking: %.2f",this.savingsBalance, this.checkingBalance));
    }
    public static int numberOfAccounts(){
        return numOfAccounts;
    }
    public static double totalValueAccounts(){
        return totalMoney;
    }

}