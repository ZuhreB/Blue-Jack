import java.util.Random;
public class Deck {
	Random rd = new Random();
private  String [] color = {"blue", "yellow" , "red" , "green" };
private int [] value = { 1,2,3,4,5,6,7,8,9,10};
Cards [] cards = new Cards[40];
Player p = new Player("user");
Player c = new Player("computer");

private int [] value2 = {1,2,3,4,5,6};
private String [] feature = {"flip","double","normal"};
private boolean sign= true;//mean it is positive 
Cards cards_player [] = new Cards[5];

public Deck(int [] value2){
    this.value2=value2;
    this.feature=feature;
    this.color=color;
    this.sign=sign;
}

public Deck (){
	this.color=color;
	this.value=value;
	int card_index=0;
for(int c=0;c<color.length;c++){
for(int v=0;v<value.length;v++){
cards[card_index]= new Cards(color[c],value[v]);
card_index++;

}
}
}

public void makeCardRandomly(){
int card_index=0;
for(int i=0;i<cards_player.length;i++){
int random =rd.nextInt(5);//for chance 20% ı randomly selected one number 
if(random==0){//it is 20%
	int random_2=rd.nextInt(2);
	if(random_2==1){
		cards_player[card_index]= new Cards("flip");
		card_index++;
	}else if(random_2==0){
	cards_player[card_index]= new Cards("double");
	card_index++;
    }
}else{
	int random_3=rd.nextInt(4);
	int random_4=rd.nextInt(6)+1;
	int random_6=rd.nextInt(2);
	if(random_6==0){
		sign=false;
	}
	String color_add = color[random_3];
	cards_player[card_index]= new Cards(random_4,"normal",color_add,sign);//
	card_index++;
}
}
}

public  void shuffle (){
	
	Cards temp;
	for(int i=0;i<cards.length;i++){
	int random =rd.nextInt(40);
	temp = cards[i];
	cards[i]=cards[random];
	cards[random]=temp;
	}
}

public void deliverySpecial(){
makeCardRandomly();
for(int i=0;i<5;i++){
	p.player_cards[p.empty_index]=cards_player[i]; 
	p.empty_index++;
}
makeCardRandomly();
for(int i=0;i<5;i++){
	c.player_cards[c.empty_index]=cards_player[i];
    c.empty_index++;	
	
}
}

public void delivery(Cards [] user, Cards [] computer){
	int i=0;
	int k=39;
	while(cards[i]!=null&&c.empty_index<5){
		c.player_cards[c.empty_index]=cards[i];
		i++;
		c.empty_index++;
	}
    while(cards[k]!=null&&p.empty_index<5){
		p.player_cards[p.empty_index]=cards[k];
	    p.empty_index++;
	    k--;
	}
}

public void showCard(){
	for(int i=0;i<cards.length;i++){
		System.out.println(cards[i]);
	}
}

public void gameCard(){
	int rndm;
	for(int i=0;i<p.game_cards.length;i++){
		rndm = rd.nextInt(10);
		p.game_cards[i]=p.player_cards[rndm];
	}
	for(int i=0;i<c.game_cards.length;i++){
		rndm = rd.nextInt(10);
		c.game_cards[i]=c.player_cards[rndm];
	}
	System.out.println("gamer 1 cards");
	for(int i=0;i<p.game_cards.length;i++){
		System.out.println(p.game_cards[i]);
	}
	System.out.println();
	
	System.out.println("gamer 2 cards");
	for(int i=0;i<c.game_cards.length;i++){
		System.out.println(c.game_cards[i]);
	}
	
}

public void showCardPlayer1(){
	for(int i=0;i<p.player_cards.length;i++){
		System.out.println(p.player_cards[i]);
	}
}

public void showCardPlayer2(){
	for(int i=0;i<c.player_cards.length;i++){
		System.out.println(c.player_cards[i]);
	}
}

}
