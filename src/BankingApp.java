import java.util.Scanner;
class BankDetails {
    private String Accountno;
    private String Name;
    private String Account Type;
    private long Balance;
    Scanner sc = new Scanner(System.in);

    //Method to open new account at the bank
    public void openAccount() {
        System.out.print("Enter Your Account No: ");
        Accountno= sc.next();
        System.out.print("Enter Your Account type: ");
        Account Type = sc.next();
        System.out.print("Enter Your Name: ");
        Name = sc.next();
        System.out.print("Enter The Existing Balance Of Your Account: ");
        Balance = sc.nextLong();
    }

    //Method to display account details relevant to requirement
    public void showAccount() {
        System.out.println("Name of account holder: " + Name);
        System.out.println("Account no.: " + Accountno);
        System.out.println("Account type: " + Account Type);
        System.out.println("Balance: " + Balance);
    }

    //Method to deposit money at account
    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        Balance = Balance + amt;
    }

    //Method to withdraw money from account
    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (Balance >= amt) {
            Balance = Balance - amt;
            System.out.println("Balance after withdrawal: " + Balance);
        } else {
            System.out.println("Your balance is less than the given amount entered i.e," + amt + "\tTransaction Unsucessful!!");
        }
    }

    //Method to search an account number being entered by the user
    public boolean search(String ac_no) {
        if (Accountno.equals(ac_no)) {
            showAccount();
            return (true);
        } else {
            return (false);
        }
    }
}


public class BankingApp{
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        //create initial accounts
        System.out.print("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails S[] = new BankDetails[n];
        for (int i = 0; i < S.length; i++) {
            S[i] = new BankDetails();
            S[i].openAccount();
        }
        
        int A;
        do {
            
            System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
            System.out.println("Enter your required activity: ");
            A = sc.nextInt();
            switch (A) {
                case 1:
                    for (int i = 0; i < S.length; i++) {
                        S[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < S.length; i++) {
                        found = S[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < S.length; i++) {
                        found = S[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < S.length; i++) {
                        found = S[i].search(ac_no);
                        if (found) {
                            S[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist");
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
            }
        }
        while (A != 5);
    }
}

