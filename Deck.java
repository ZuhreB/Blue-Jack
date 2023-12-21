import java.util.Random;
import java.util.Scanner;
  public class Deck {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
    private  String [] color = {"blue", "yellow" , "red" , "green" };
    private int [] value = { 1,2,3,4,5,6,7,8,9,10};
    Cards [] cards = new Cards[40];
	
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
for(int i=0;i<3;i++){
	int random_3=rd.nextInt(4);
	int random_4=rd.nextInt(6)+1;
	int random_6=rd.nextInt(200);
	if(random_6%2==0){
		sign=false;
	}else{
		sign=true;
	}
	String color_add = color[random_3];
	cards_player[card_index]= new Cards(random_4,"normal",color_add,sign);//
	card_index++;
}

for(int i=0;i<2;i++){
int random =rd.nextInt(500);//for chance 20% ı randomly selected one number 
if(random<100){//it is 20%
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
	int random_6=rd.nextInt(200);
	if(random_6%2==0){
		sign=false;
	}else{
		sign=true;
	}
	String color_add = color[random_3];
	cards_player[card_index]= new Cards(random_4,"normal",color_add,sign);//
	card_index++;
	
}


   }
   
   }
   
}
