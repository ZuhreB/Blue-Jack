import java.util.Random;
import java.util.Scanner;
import java.util.Formatter;
import java.io.IOException;
import java.nio.file.Paths;
public class Ruler{
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
    Deck d1 = new Deck();
    
	boolean control_top_score=false;

    public  void shuffle (Cards [] cards){
	Cards temp;
	for(int i=0;i<cards.length;i++){
	int random =rd.nextInt(40);
	temp = cards[i];
	cards[i]=cards[random];
	cards[random]=temp;
	}
}

	public void delivery(Player user , Player cp , Cards [] cards){
		int i=0;
		int k=39;
		while(cards[i]!=null&&cp.empty_index<5){
			cp.player_cards[cp.empty_index]=cards[i];
			cards[i]=null;
			i++;
			cp.empty_index++;
			}
			while(cards[k]!=null&&user.empty_index<5){
				user.player_cards[user.empty_index]=cards[k];
				cards[k]= null;
				user.empty_index++;
				k--;
				}
				}
	
	public void deliverySpecial(Player user , Player cp, Cards [] cards){
		d1.makeCardRandomly();
		for(int i=0;i<5;i++){
			user.player_cards[user.empty_index]=d1.cards_player[i]; 
			user.empty_index++;
			}
			d1.makeCardRandomly();
			for(int i=0;i<5;i++){
				cp.player_cards[cp.empty_index]=d1.cards_player[i];
				cp.empty_index++;
				}
				}

    public void showCard(Cards [] cards){
		for(int i=0;i<cards.length;i++){
			if(cards[i]==null){
				continue;
				}
				System.out.println(cards[i]);
				}
	}

    public void gameCard(Player user){
		int rndm;
		while(user.index_game_card<4){
			rndm=rd.nextInt(10);
			if(user.player_cards[rndm]!=null){
				user.game_cards[user.index_game_card]=user.player_cards[rndm];
				user.player_cards[rndm]=null;
				user.index_game_card++;
				}
				}
				System.out.println(user.getName()+"'s cards");
				for(int i=0;i<user.game_cards.length;i++){
					System.out.println(user.game_cards[i]);
					}
					}
					
	public void giveBoard(Player player,Cards [] cards){
		for(int i=0;i<cards.length;i++){
			if(cards[i]!=null&&player.play==true){	
			player.board_cards[player.board_card_index]=cards[i];
			player.board_card_index++;
			cards[i]= null;
			break;
			}
			if(player.getName().equals("computer")){
				if(player.score>=17){
				player.play=false;
				}
			}		}
		System.out.println(player.board_cards[player.board_card_index-1]+" in the board");
				}

    public void check(Player player){
		int score_n=0;
		int counter=0;
		control_top_score=false;
		for(int i=0;i<player.board_cards.length;i++){
			if(player.board_cards[i]==null){
				continue;
			}
			if(player.board_cards[player.board_card_index-1].getFeature()==null){
				continue;
				}else if (player.board_cards[player.board_card_index-1].getFeature().equals("flip")){
						player.board_cards[player.board_card_index-2].setValue(player.board_cards[player.board_card_index-2].getValue()*-1);
		        }else if (player.board_cards[player.board_card_index-1].getFeature().equals("double")){
					player.board_cards[player.board_card_index-2].setValue(player.board_cards[player.board_card_index-2].getValue()*2);
					}
			if(player.board_cards[i].getFeature().equals("flip")||player.board_cards[i].getFeature().equals("double")){
				continue;
			}else if(player.board_cards[i].getSign()==true){
				score_n+=player.board_cards[i].getValue();
			}else{
				score_n-=player.board_cards[i].getValue();
			}
		}
			if(score_n==20){
				System.out.println(player.getName()+" win");
				for(int i=0;i<player.board_cards.length;i++){
					if(player.board_cards[i]!=null){
						if(player.board_cards[i].getColor().equals("blue")){
						player.top_score++;
						control_top_score=true;
						System.out.println("BLUJACK !!!!");
				        }
					}
				}
				player.score++;
				}
			if(score_n>20){
				System.out.println( player.getName()+" are  bust");
				}	
			System.out.println(score_n+" point in the board");
			player.score=score_n;
				
		}

    public void calculate_score(Player user , Player c){
		control_top_score=false;
		if(user.score==20){
			user.top_score++;
			control_top_score=true;
		}if(c.score==20){
			c.top_score++;
			control_top_score=true;
		}if(user.score==20&&c.score==20){
			System.out.println("scoreless");	
			control_top_score=true;
		}if(user.score>20){
			if(c.score<20){
				c.top_score++;
				control_top_score=true;
			}
		}if(c.score>20){
			if(user.score<20){
				user.top_score++;
				control_top_score=true;
			}
		}if(user.board_card_index==8||c.board_card_index==8){
			if(user.score<20&&c.score<20){
			if(user.score>c.score){
				user.top_score++;
				control_top_score=true;
			}else{
				c.top_score++;
				control_top_score=true;
			}
		}
		}
		
		Formatter f = null;
		Scanner reader = null;
		try {
			f = new Formatter("ScoreFile.txt");
			f.format("%s: %s",user.getName() +user.top_score ," computer :"+c.top_score );
			} catch (Exception e) {
				System.err.println("Something went wrong.");
				} finally {
					if (f != null) {
						f.close();
						}
					}
					
		try {
			reader = new Scanner (Paths.get("ScoreFile.txt"));
			while(reader.hasNextLine ()) {
				System.out.println(reader.nextLine ());
				}
				} catch (IOException e) {
					e. printStackTrace ();
					} finally {
						if (reader != null) {
							reader.close();
							}
						}


		
	}
	
}