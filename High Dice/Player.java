import java.util.Scanner;

public class Player{
    private int chips = 6, bet = 0;
    private String name;
    public Player(String name){
        this.name = name;
    }
    public String getName(){return name;}
    public int getChips(){return chips;}
    public void setChips(int n){chips = n;}
    public int getBet(){return bet;}
    public void bet(){
        Scanner scan = new Scanner(System.in);
        System.out.println(name + ", place your bet: ");
        bet = -1;
        while(bet < 0 || bet > 6){
            try{
                bet = scan.nextInt();
            }catch(Exception e){
                System.out.println("That is invalid (must be an int and >= than 1 and <= 6)");
            }
            if(bet < 0 || bet > 6)System.out.println("That is invalid (must be an int and >= than 1 and <= 6)");
        }
        System.out.println(name + " bet "+bet+"!");
        System.out.println(name + ", amount of chips you're betting: ");
        while(bet < 0){
            try{
                bet = scan.nextInt();
            }catch(Exception e){
                System.out.println("That is invalid (must be an int and >= than 1");
            }
            if(bet < 0)System.out.println("That is invalid (must be an int and >= than 1");
        }
        System.out.println(name + " bet "+chips+" chips.");
    }
    public void roll(int die1, int die2) {
        int m = (int)(Math.random() * 6 - 1) + 1;
        int m2 = (int)(Math.random() * 6 - 1) + 1;
        if(m > die1 && m2 > die2 || m > die2 && m2 > die1){
            
        }
    }
}