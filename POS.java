public class MenuItem{
     private String name;
     private double price;


public MenuItem(String name,double price){   //constructor
   this.name=name;
   this.price=price;
}


public String getName(){             // using of getmethod for return the menuitem
    return name;
}

public double getprice(){
    return price;

}

//Override

public String toString(){
  return name+"-$"+String.format("%.2f",price);
   }

}






import java.util.ArrayList;
import java.util.List;

public class Order{
       private List<MenuItem> items;
       private double total;


        public Order(){
        items=new ArrayList<>();
        total =0.0;

}


public void addItem(MenuItem item){
   items.add(item);
   total+= item.getPrice();
}


public double getTotal(){
     return Total;
}


public void printOrder(){
      System.out.println("Order Summary:");
      for (MenuItem item:items){
        System.out.println(item);
     }

 System.out.println("Total:$"+String.formate("%.2f",totel));
}


 public void clear(){
     items.clear();
     total=0.0;
   }
}



import java.util.Scanner;

public class POS{
      private static MenuItem[]menu={
     new MenuItem("lemonwater",1.45),
     new MenuItem("salad",4.48),
     new MenuItem("lassi",2.00),
     new MenuItem("icecream",3.21),
     new MenuItem("bhel",2.23)
};

public static void main(String[]args){
  Scanner s=new Scanner(System.in);
  Order o=new Order();
  boolean running=true;

while(running){
     displayMenu();
    System.out.print("Select an item by num(or enter 0 to finish):");
    int choice=s.nextInt();

if(choice==0){
 running=false;
  break;
}

if(choice< 1 || choice >menu.length){
     System.out.println("invalid choice.plz try again.");
     continue;
}

     MenuItem selectedItem=menu[choice-1];
     order.addItem(selectedItem);
     System.out.println("Added:"+selectedItem);  
}

    o.printOder();
    s.close();
}
private static void displayMenu(){
    System.out.println("Menu:");
   for(int i=0; i<menu.length;i++){
       System.out.println((i+1)+". "+menu[i]);

          }

      }

}









