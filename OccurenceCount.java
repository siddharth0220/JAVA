import java.util.*;
class OccurenceCount{

  public static void Repeatation_Ch(String name)
  {
  HashMap<Character,Integer> map=new HashMap<>();
    char array_ch[]=name.toCharArray();
    for(char c:array_ch)
    {
    if(map.containsKey(c)){
      map.put(c,map.get(c)+1);
    }  
      else{
      map.put(c,1);
      }
  }  
    System.out.println(name +":"+map);}
  public static void main(String []args){
  Repeatation_Ch("Siddharth");
  Repeatation_Ch("Siddharth Kumar Pradhan");
}}
  
