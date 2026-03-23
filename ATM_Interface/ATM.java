import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account){
        this.account = account;
    }

    // deposit method
    public void deposit(double amount){
        double currBalance = account.getBalance();
        account.setBalance(currBalance+amount);
        System.out.println("Rupees "+amount+" deposited successfully");

    }

    // withdraw method
    public void withdraw(double amount){
        double currBalance = account.getBalance();
        if(currBalance<amount){
            System.out.println("Insufficient amount to withdraw");
        }
        else{
            account.setBalance(currBalance - amount);
            System.out.println("Rupees "+amount+" withdrawn successfully");
        }
    }

    // check balance
    public void checkBalance(){
        System.out.println("Current balance: "+account.getBalance());
    }

    // Menu
    public void startATM(){
        Scanner sc = new Scanner(System.in);
        int choice;
         do {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit:");
                    double amount = sc.nextDouble();
                    if(amount > 0){
                        deposit(amount);
                    }else{
                        System.out.println("Invalid deposit amount");
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter the amount you want to withdraw:");
                    double amount1 = sc.nextDouble();
                    if(amount1 > 0 ){
                        withdraw(amount1);
                    }else{
                        System.out.println("Invalid withdraw amount");
                    }
                    break;
                    
                case 4:
                    System.out.println("Thank you for using the ATM Machine");
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
        }while(choice !=4);

        sc.close();
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);

        atm.startATM();
    }
}
