public class Cards {
private String feature;
private String color ;
private int value ;
private String name;
private boolean sign;

public Cards(String color , int value){
    this.color=color;
    this.value=value;
    this.name=this.color+" "+ this.value;
}
public Cards(int value, String feature , String color,boolean sign){
	this.value=value;
	this.feature=feature;
	this.color=color;
	this.sign=sign;
	this.name =this.color+" "+ this.value+" "+this.feature+" "+this.sign;
}
public Cards(String feature){
	this.feature=feature;
	this.name =this.feature;
}

public int getValue(){
	return value;
}
public  String getColor(){
    return color;
}
public String getFeature(){
	return feature;
}
public void setValue(int value){
	this.value=value;
}
public void setColor(String color){
	this.color=color;
}
public void setFeature(String feature){
	this.feature=feature;
}
public String toString() { 
	return  name;

}
}