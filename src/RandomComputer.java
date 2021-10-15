import java.util.Random;

public class RandomComputer {
    private int [] cards = new int[21];
    private int sum ;


    public void generateCard(){
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
    }
    private void showTotal(){
        sum = 0;
        for (int i = 0; i < cards.length; i++) {
            this.sum += cards[i];
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
                Random random = new Random();
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
        for (int i = 0; i < cards.length; i++) {
            cards[i]=0;
        }
    }
}

