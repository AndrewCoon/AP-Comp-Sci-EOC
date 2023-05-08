import java.util.Scanner;

public class Player{
    private int chips = 10, bet = 0;
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
        bet = -1;
        System.out.println(name + ", amount of chips you're betting(you have "+chips+"chips): ");
        while(bet < 0 || bet > chips){
            try{
                bet = scan.nextInt();
            }catch(Exception e){
                System.out.println("That is invalid (must be an int and >= than 1");
            }
            if(bet < 0 || bet > chips)System.out.println("That is invalid (must be an int and >= than 1, must be in your chip range)");
        }
        System.out.println(name + " bet "+bet+" chips.");
        this.setChips(this.getChips() - this.getBet());
        scan.close();
    }
    public void roll(int die1, int die2) {
        int m = (int)(Math.random() * 6 - 1) + 1;
        int m2 = (int)(Math.random() * 6 - 1) + 1;
        System.out.println(name + " rolled "+m+" and "+m2);
        if(m > die1 && m2 > die2 || m > die2 && m2 > die1){
            System.out.println(name + " won their bet!");
            this.setChips(this.getChips() + this.getBet() + this.getBet());
        }else{
            System.out.println(name + " lost their bet!");
        }
    }
}