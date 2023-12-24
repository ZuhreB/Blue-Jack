import java.util.Scanner;
public class Play{
	
	
	public static void main (String [] args){
		
		Scanner sc = new Scanner(System.in);
		Deck d1 = new Deck();
		Ruler r= new Ruler();
		String player_name;
		System.out.println("please enter your name");
		player_name=sc.nextLine();
		Player p = new Player(player_name);
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
		System.out.println(p.getName()+"'s cards");
	    r.showCard(p.game_cards);
		r.giveBoard(p,d1.cards);
		p.play(p);
		System.out.println();
		System.out.println("computer play");
		r.giveBoard(c,d1.cards);
		System.out.println(c.getName()+"'s cards");
		r.showCard(c.game_cards);
		c.playComputer(c);
		r.calculate_score(p,c);
		
		
		
		while(r.control_top_score==false){
			int caunter =0;
			if(p.control==false||c.control==false){
				System.out.println(p.getName()+"'s cards");
				r.showCard(p.game_cards);
				System.out.println();
				r.giveBoard(p,d1.cards);
				p.play(p);
				System.out.println();
				System.out.println("computer play");
				r.giveBoard(c,d1.cards);
				System.out.println(c.getName()+"'s cards");
				r.showCard(c.game_cards);
				c.playComputer(c);
				r.calculate_score(p,c);
			}
			if(r.control_top_score==true){
				break;
			}
			
		}
	}
}
