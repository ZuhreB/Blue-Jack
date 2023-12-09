public class Play{
public static void main (String [] args){
Deck d1 = new Deck();
System.out.println("Game cards");
d1.showCard();
System.out.println();
System.out.println("shuffled cards");
d1.shuffle();
d1.showCard();
System.out.println();
System.out.println("delivery");
d1.delivery(d1.p.player_cards,d1.c.player_cards);
d1.deliverySpecial();
System.out.println();
System.out.println("gamer 1 cards");
d1.showCardPlayer1();
System.out.println();
System.out.println("gamer 2 cards");
d1.showCardPlayer2();
System.out.println();
d1.gameCard();
System.out.println();
d1.play();
}
}