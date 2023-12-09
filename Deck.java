import java.util.Random;
import java.util.Scanner;
public class Deck {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
private  String [] color = {"blue", "yellow" , "red" , "green" };
private int [] value = { 1,2,3,4,5,6,7,8,9,10};
Cards [] cards = new Cards[40];
Player p = new Player("user");
Player c = new Player("computer");

private int [] value2 = {1,2,3,4,5,6};
private String [] feature = {"flip","double","normal"};
private boolean sign= true;//mean it is positive 
Cards cards_player [] = new Cards[5];
Cards cards_computer_board [] = new Cards [9];
Cards cards_player_board [] = new Cards [9];

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
		cards[i]=null;
		i++;
		c.empty_index++;
	}
    while(cards[k]!=null&&p.empty_index<5){
		p.player_cards[p.empty_index]=cards[k];
		cards[k]= null;
	    p.empty_index++;
	    k--;
	}
}

public void showCard(){
	for(int i=0;i<cards.length;i++){
		if(cards[i]==null){
			continue;
		}
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

public void giveBoard(Cards [] cards_player_board){
	int index=0;
for(int i=0;i<cards.length;i++){
if(cards[i]==null){
continue;
}else{		
cards_player_board [index+1]=cards[i];
cards[i]= null;
index++;
if(index==1){
	break;
}
}
}
System.out.println(cards_player_board [index]+" in the board");
}

public void check(Cards[] cards_player_board){
	int sum_points=0;
	int caunter=0;
	for(int i=0;i<cards_player_board.length;i++){
		sum_points+=cards_computer_board[i].getValue();
	}
	for(int i=0;i<cards_player_board.length;i++){
		if(cards_player_board[i].getColor().equals("blue")){
			caunter++;
		}
	}
	if(caunter>=4){
		System.out.println("u win u use all blue cards");
	}
	if(sum_points==20){
		System.out.println("u win");
	}
}
public void play(){
	
	giveBoard(cards_player_board);
	int index_move=0;
	System.out.println("do u wanna move your special card 1: yes 2: no");
	boolean play = false;
	int scan = sc.nextInt();
	if(scan==1){
		play= true;
	}
	while(play==true){
	System.out.println("which cards dou u wanna move 1st 2nd 3rd 4td ");
	int move=sc.nextInt();
	if(p.game_cards[move-1]!=null){
	cards_player_board[index_move]=p.game_cards[move-1];
	index_move++;
	p.game_cards[move-1]=null;
	play=false;

	}
	else{
		System.out.println("please enter a diifferent one ");
		move=sc.nextInt();
	}
}
}
public void play_computer(){
	giveBoard(cards_computer_board);
}

}
