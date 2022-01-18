public class BankAccountTest{
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        
        System.out.println(BankAccount.numOfAccounts);

        bankAccount.depositMoney("savings", 200);
        bankAccount.depositMoney("checking", 500);
        bankAccount.withdrawMoney("savings", 100);
        bankAccount.withdrawMoney("checking",200);
        bankAccount.displayAccountBalance();
        System.out.println(BankAccount.totalValueAccounts());
    }
}