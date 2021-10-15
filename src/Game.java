import java.util.Scanner;

public class Game {
    Player player;
    RandomCards randomCardsHuman;
    RandomCards randomCardsComputer;
    Scanner scannerNr;

    public Game() {
        player = new Player();
        randomCardsHuman = new RandomCards();
        randomCardsComputer = new RandomCards();
        scannerNr = new Scanner(System.in);
    }

    public void startGame() {
        player.introdBalance();
        int opt;
        do {
            player.introdAmount();
            playerChooseCardMenu();
            randomCardsComputer.computerAlgoritm();
            showResults(randomCardsHuman.getSum(), randomCardsComputer.getSum());
            playAgain();
            opt = scannerNr.nextInt();
            randomCardsHuman.resetArray();
            randomCardsComputer.resetArray();
        } while (opt == 1);
    }

    private boolean checkWinLoose() {
        boolean isTrue = false;
        if (randomCardsHuman.getSum() > 21) {
            isTrue = true;
        } else if (randomCardsHuman.getSum() == 21) {
            isTrue = true;
        }
        return isTrue;
    }

    private void showResults(int valuePlayer, int valueComputer) {
        if (valuePlayer > 21) {
            if (valueComputer > 21) {
                equalProcedure();
            } else {
                looseProcedure();
            }
        } else if (valuePlayer == 21) {
            if (valueComputer == 21) {
                equalProcedure();
            } else {
                winProcedure();
            }
        } else {
            if (valueComputer > 21) {
                winProcedure();
            } else if (valueComputer == 21) {
                looseProcedure();
            } else {
                if (valueComputer > valuePlayer) {
                    looseProcedure();
                } else if (valueComputer == valuePlayer) {
                    equalProcedure();
                } else {
                    winProcedure();
                }
            }
        }
    }

    private void winProcedure() {
        System.out.println("Ai castigat, ai avut " + randomCardsHuman.getSum() + " calculatorul a avut " + randomCardsComputer.getSum());
        player.winGame();
    }

    private void equalProcedure() {
        System.out.println("Egalitate, ai avut " + randomCardsHuman.getSum() + " calculatorul a avut " + randomCardsComputer.getSum());
    }

    private void looseProcedure() {
        System.out.println("Ai pierdut, ai avut " + randomCardsHuman.getSum() + " calculatorul a avut " + randomCardsComputer.getSum());
        player.looseGame();
    }
    private void playerChooseCardMenu(){
        do {
            System.out.println("Cartea trasa este : " + randomCardsHuman.generateCard());
            System.out.println("Total : " + randomCardsHuman.getSum());
            if (checkWinLoose()) {
                return;
            }
            player.menu();
        } while (player.getOpt() == 1);
    }
    private void playAgain(){
        System.out.println("Balanta ta este : " + player.getBalance());
        System.out.println("1.Da");
        System.out.println("2.Nu");
        System.out.print("Alege optiune daca vrei sa joci din nou : ");
    }

}
