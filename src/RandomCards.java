import java.util.Arrays;
import java.util.Random;

public class RandomCards {
    private final int [] cards = new int[15];
    private int sum ;


    public int generateCard(){
        Random random = new Random();
        int card = random.nextInt(13) + 2;
        if(card >11){
            card = 10;
        }
        for (int i = 0; i < cards.length; i++) {
            if(cards[i] == 0){
                cards[i]=card;
                break;
            }
        }
        return card;
    }

    private void showTotal(){
        sum = 0;
        for (int card : cards) {
            this.sum += card;
        }
        if(sum > 21){
            for (int i = 0; i < cards.length; i++) {
                if(cards[i] == 11){
                    cards[i] = 1;
                    showTotal();
                }
            }
        }
    }

    public int getSum() {
        showTotal();
        return sum;
    }
    public void computerAlgoritm(){
        boolean checkIfFinish = true;
        while (checkIfFinish) {
            if (getSum() < 15) {
                generateCard();
            } else if (getSum() < 18) {
                java.util.Random random = new java.util.Random();
                int risc = random.nextInt(2);
                if (risc == 0) {
                    generateCard();
                }
                checkIfFinish = false;
            } else {
                checkIfFinish = false;
            }
        }
    }
    public void resetArray(){
        Arrays.fill(cards, 0);
    }
}

