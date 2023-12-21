import java.util.Random;
import java.util.Scanner;
public class Player{
	
    Cards player_cards [] =new Cards[10];
    Cards game_cards [] = new Cards [4];
	Cards board_cards [] = new Cards[9];
	Ruler r= new Ruler();
	private String name;
	int empty_index;
	int board_card_index;
	int index_game_card=0;
	boolean play=true;
	int score;
	int top_score;
	
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	public Player(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
   public void play(Player p){
	   int scan;
	   int mover;
	   System.out.println("Do you want to play?");
	   scan=sc.nextInt();
	   if(scan==1){
		   p.play=true;
		   System.out.println("Which card do u want to move?");
		   mover=sc.nextInt();
		   if(p.game_cards[mover-1]!=null){
			   p.board_cards[p.board_card_index]=p.game_cards[mover-1];
			   p.board_card_index++;
			   p.game_cards[mover-1]= null;
		   }else if(p.game_cards[mover-1]==null){
			System.out.println("please choose another one");   
		   }
	   }
r.check(p);
System.out.println();	 
System.out.println(p.getName()+"'s elindeki kartlar");
r.showCard(p.game_cards);
System.out.println();
System.out.println("masadaki kartlar");
r.showCard(p.board_cards);


}

  public void playComputer(Player c){
	int board_sum=0;
	int rnd=0;
	for(int i=0;i<c.board_cards.length;i++){
		if(c.board_cards[i]==null){
			continue;
		}else if(c.board_cards[i]!=null){
		board_sum+=c.board_cards[i].getValue();
		break;
		}
	}
	for(int i=0;i<c.game_cards.length;i++){
		 if(c.game_cards[i]==null){
			continue;
		}
		else if(c.score>17){
			System.out.println("computer wan to stand");
			c.play=false;
			break;
		}
		if(c.play=false){
			break;
		}else if(c.game_cards[i].getValue()+c.score==20){
			
			c.board_cards[c.board_card_index]=c.game_cards[i];
			c.board_card_index++;
			c.game_cards[i]=null;
			break;
		}else if (c.game_cards[i].getFeature().equals("flip")){
			if(c.game_cards[i].getSign()!=c.game_cards[c.board_card_index-1].getSign()){
				board_sum=board_sum-c.game_cards[c.board_card_index-1].getValue();
				c.game_cards[c.board_card_index-1].setValue(c.game_cards[c.board_card_index-1].getValue()*-1);
				if(c.game_cards[c.board_card_index-1].getValue()+board_sum==20){
					c.board_cards[c.board_card_index]=c.game_cards[i];
			        c.board_card_index++;
			        c.game_cards[i]=null;
					board_sum=board_sum+c.game_cards[c.board_card_index-1].getValue();
			        break;
				}
			}
		}else if (c.game_cards[i].getFeature().equals("double")){
			board_sum=board_sum-c.game_cards[c.board_card_index-1].getValue();
			c.game_cards[c.board_card_index-1].setValue(c.game_cards[c.board_card_index-1].getValue()*2);
			if(c.game_cards[c.board_card_index-1].getValue()+board_sum==20){
				c.board_cards[c.board_card_index]=c.game_cards[i];
			    c.board_card_index++;
			    c.game_cards[i]=null;
				board_sum=board_sum+c.game_cards[c.board_card_index-1].getValue();
			        break;
			}
		
		}else if(c.game_cards[rnd].getValue()+c.score>=20){
			System.out.println("computer do not move any card");
			break;
		}
	}


r.check(c);
System.out.println();
System.out.println(c.getName()+"'s elindeki kartlar");
r.showCard(c.game_cards);
System.out.println();
System.out.println("masadaki kartlar");
r.showCard(c.board_cards);

}

}