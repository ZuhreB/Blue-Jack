import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Player{
	
    Cards player_cards [] =new Cards[10];
    Cards game_cards [] = new Cards [4];
	Cards board_cards [] = new Cards[9];
	Ruler r= new Ruler();
	
	private String name;
	public int empty_index;
	public int board_card_index;
	public int index_game_card=0;
	public boolean play=true;;
	public int score;
	public int top_score;
	boolean control=false;
	int read;
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
	   int scan=0;
	   int mover;
	   try {
		   System.out.println("Stand or continue? choose s:1 or c:2");
		   read=sc.nextInt();
		   if(read==1){
			   p.play=false;
			   p.control=true;
		   }
       } catch (Exception e) {
		   System.out.println("can not read");
	   } finally {
	   }
	   while( read==2) {
		   try {
		   System.out.println("Do you want to play? 1: yes 2:no ");
		   scan=sc.nextInt();
       } catch (Exception e) {
		   System.out.println("can not read");
	   } finally {

	   }
		   if(scan==1){
			   System.out.println("Which card do u want to move?");
			   mover=sc.nextInt();
			    if(p.game_cards[mover-1]==null){
					  System.out.println("please choose another one");  
					  mover=sc.nextInt();
					  }
			   while(game_cards[mover-1]!=null){
				   if(p.game_cards[mover-1]!=null){
					   p.board_cards[p.board_card_index]=p.game_cards[mover-1];
					   p.board_card_index++;
					   System.out.println(p.game_cards[mover-1]+" played ");
					   p.game_cards[mover-1]= null;
					   read=1;
					   break;
				  }
				  
			   }
		  }else{
			  break;
			  }
			  if(read==1){
				  p.play=false;
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
	rnd=rd.nextInt(4);
	for(int i=0;i<c.board_cards.length;i++){
		if(c.board_cards[i]==null){
			continue;
		}else if(c.board_cards[i]!=null){
		board_sum+=c.board_cards[i].getValue();
		}
	}//bilgisayarın tahtasındaki kartların değerini topladı
	for(int i=0;i<c.game_cards.length;i++){
		 if(c.game_cards[i]==null){
			continue;
		}if(c.score>=17){
			System.out.println(c.getName()+" want to stand"); 
			c.play=false;
			c.control=true;
			break;
		}
		else if(c.game_cards[i].getValue()+c.score==20){
			c.board_cards[c.board_card_index]=c.game_cards[i];
			c.board_card_index++;
			c.game_cards[i]=null;
			break;
		}else if (c.game_cards[i].getFeature().equals("flip")){
			if(board_sum>20) {
				board_sum=board_sum-c.board_cards[c.board_card_index-1].getValue();
				c.board_cards[c.board_card_index-1].setValue(c.board_cards[c.board_card_index-1].getValue()*-1);
				board_sum=board_sum+c.board_cards[c.board_card_index-1].getValue();
				c.board_cards[c.board_card_index]=c.game_cards[i];
			    c.board_card_index++;
			    c.game_cards[i]=null;
			    break;
			}
		}else if (c.game_cards[i].getFeature().equals("double")){
			board_sum=board_sum-c.board_cards[c.board_card_index-1].getValue();
			c.board_cards[c.board_card_index-1].setValue(c.board_cards[c.board_card_index-1].getValue()*2);
			if(c.board_cards[c.board_card_index-1].getValue()+board_sum==20){
				c.board_cards[c.board_card_index]=c.game_cards[i];
			    c.board_card_index++;
			    c.game_cards[i]=null;
				board_sum=board_sum+c.game_cards[c.board_card_index-1].getValue();
			        break;
			}
		}else {
			rnd=rd.nextInt(4);
			if(c.game_cards[rnd]==null){
				break;
			}if(c.game_cards[rnd]!=null&&c.game_cards[rnd].getFeature().equals("normal")) {
				if(c.game_cards[rnd].getValue()+c.score>=20||c.game_cards[rnd].getValue()+c.score<=0){
					System.out.println("computer do not move any card");
					break;
					}else if (c.game_cards[rnd].getValue()+c.score<20){
						if(c.game_cards[rnd]!=null){
							c.board_cards[c.board_card_index]=c.game_cards[i];
							c.board_card_index++;
							c.game_cards[i]=null;
							break;
							}
					}
			}
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
