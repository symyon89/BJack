import java.util.Random;

public class RandomHuman {
    private int [] cards = new int[21];
    private int sum;


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
    public void resetArray(){
        for (int i = 0; i < cards.length; i++) {
            cards[i]=0;
        }
    }
}
