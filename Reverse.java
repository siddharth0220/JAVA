public class Reverse{
public static main(String[]args){
  String Original="Siddharth";
  String Reversed="";
  char ch;
  for(int i=0;i<Original.length();i++){
    ch=Original.charAt(i);
    Reversed= ch + Reversed;
  }
  System.out.println("The Original String is : " +Original);
  System.out.println("The Reversed String is : " +Reversed);
}
