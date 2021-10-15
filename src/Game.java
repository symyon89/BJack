import java.util.Scanner;

public class Game {
    Player player;
    RandomHuman randomHuman;
    RandomComputer randomComputer;
    Scanner scannerNr;

    public Game() {
        player = new Player();
        randomHuman = new RandomHuman();
        randomComputer = new RandomComputer();
        scannerNr = new Scanner(System.in);
    }

    public void startGame() {
        player.introdBalance();
        int opt = 1;
        do {
            player.introdAmount();
            do {
                System.out.println("Cartea trasa este : " + randomHuman.generateCard());
                System.out.println("Total : " + randomHuman.getSum());
                if (!checkWinLoose()) {
                    break;
                }
                player.menu();
            } while (player.getOpt() == 1);
            randomComputer.computerAlgoritm();
            showResults(randomHuman.getSum(), randomComputer.getSum());
            System.out.println("1.Da");
            System.out.println("2.Nu");
            System.out.print("Alege optiune daca vrei sa joci din nou : ");
            opt = scannerNr.nextInt();
            randomHuman.resetArray();
            randomComputer.resetArray();
        } while (opt == 1);
    }

    private boolean checkWinLoose() {
        boolean isTrue = true;
        if (randomHuman.getSum() > 21) {
            isTrue = false;
        } else if (randomHuman.getSum() == 21) {
            isTrue = false;
        }
        return isTrue;
    }

    private void showResults(int valuePlayer, int valueComputer) {
        if (valuePlayer > 21) {
            if (valueComputer > 21) {
                equalProcedure(valuePlayer, valueComputer);
            } else {
                looseProcedure(valuePlayer, valueComputer);
            }
        } else if (valuePlayer == 21) {
            if (valueComputer == 21) {
                equalProcedure(valuePlayer, valueComputer);
            } else {
                winProcedure(valuePlayer, valueComputer);
            }
        } else {
            if (valueComputer > 21) {
                winProcedure(valuePlayer, valueComputer);
            } else if (valueComputer == 21) {
                looseProcedure(valuePlayer, valueComputer);
            } else {
                if (valueComputer > valuePlayer) {
                    looseProcedure(valuePlayer, valueComputer);
                } else if (valueComputer == valuePlayer) {
                    equalProcedure(valuePlayer, valueComputer);
                } else {
                    winProcedure(valuePlayer, valueComputer);
                }
            }
        }
    }

    public void winProcedure(int valuePlayer, int valueComputer) {
        System.out.println("Ai castigat, ai avut " + valuePlayer + " calculatorul a avut " + valueComputer);
        player.winGame();
    }

    public void equalProcedure(int valuePlayer, int valueComputer) {
        System.out.println("Egalitate, ai avut " + valuePlayer + " calculatorul a avut " + valueComputer);
    }

    public void looseProcedure(int valuePlayer, int valueComputer) {
        System.out.println("Ai pierdut, ai avut " + valuePlayer + " calculatorul a avut " + valueComputer);
        player.looseGame();
    }
}
