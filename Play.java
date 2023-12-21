import java.util.Scanner;
public class Play{
public static void main (String [] args){
Scanner sc = new Scanner(System.in);
Deck d1 = new Deck();
Ruler r= new Ruler();
System.out.println("please enter your name");
Player p = new Player(sc.nextLine());
System.out.println(" your name " +p.getName());
Player c= new Player("computer");
System.out.println("Game cards");
r.showCard(d1.cards);
System.out.println();
System.out.println("shuffled cards");
r.shuffle(d1.cards);
r.showCard(d1.cards);
System.out.println();
System.out.println("delivery");
r.delivery(p,c,d1.cards);
r.deliverySpecial(p,c,d1.cards);
System.out.println();
System.out.println("gamer 1 cards");
r.showCard(p.player_cards);
System.out.println();
System.out.println("gamer 2 cards");
r.showCard(c.player_cards);
System.out.println();
r.gameCard(p);
System.out.println();
r.gameCard(c);
System.out.println();
int caunter=0;
for(int i=0;i<d1.cards.length;i++){
if(d1.cards[i]==null){
	caunter++;
}
}
while(caunter<=40){
	r.giveBoard(p,d1.cards);
	p.play(p);
	System.out.println();
	System.out.println("computer playyyyyyyyyyyyyyy");
	r.giveBoard(c,d1.cards);
	c.playComputer(c);
	r.calculate_score(p,c);
	if(c.score>=20||p.score>=20){
			break;
		}
		
}


}
}