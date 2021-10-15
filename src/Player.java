import java.util.Scanner;

public class Player {
    private int balance = 0;
    private int betAmount;
    private Scanner scannerNr = new Scanner (System.in);
    private int opt;


    public void introdBalance(){
        int temp;
            System.out.print("Introdu credit : ");
            temp = scannerNr.nextInt();
            if(this.checkValidity(temp)){
                introdBalance();
            }else {
                this.balance += temp;
            }

    }

    public void introdAmount(){
        System.out.println("Creditul tau este : " + balance);
        if(balance < 1){
            System.out.println("Nu ai indeajuns credit pentru a juca");
            introdBalance();
        }
        System.out.print("Introdu valoare de pariere :");
        betAmount = scannerNr.nextInt();
        if(checkValidity(betAmount)){
            introdAmount();
        }
    }
    private boolean checkValidity(int numberToCheck){
        if(numberToCheck <= 0){
            System.out.println("Ai introdus o valoare gresita");
            return true;
        }else {
            return false;
        }
    }
    public void winGame(){
        balance +=betAmount;
    }
    public void looseGame(){
        balance -=betAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void menu(){
        System.out.println("1.Trage o carte noua");
        System.out.println("2.Ma opresc");
        System.out.print("Alege optiune : ");
        opt = scannerNr.nextInt();
        if(opt !=1 && opt !=2){
            System.out.println("Nu ai selectat o optiune valida!!");
            menu();
        }
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }
}
