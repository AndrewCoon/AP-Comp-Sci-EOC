/*
 *  This game can actually now and then be found in casinos. For 4–10 players; one must be
    the Banker. You need four dice, plus a sufficient amount of chips or coins. The Banker’s
    dice should preferrably be of a different colour, so as to differentiate them from the two
    Player dice.
    Aim of the game: To win money by rolling higher than the Banker.
    How to play: Before every round, each player places his bet before him on the table.
    The players decide the size of their own bets.
    The Banker then rolls his two dice. If the Banker rolls 1-1, the Banker has
    immediately lost and all players win even money. If you bet 5 chips, you get your bet
    back plus another 5 chips from the Banker.
    If the Banker dice show any other result, they are left on the table and each player in
    turn clockwise has one roll with the Player dice, trying to throw higher than the Banker
    did.
    A player rolling higher than the Banker wins even money. A player rolling lower or
    equal to the Banker’s roll loses his bet, however.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("== HIGH DICE ==");
        ArrayList<Player> players = new ArrayList<>();
        // Get players
        System.out.println("== High Dice > Game > Players ==");   
        // scan
        Scanner scan = new Scanner(System.in);
        String name = "NULL";
        while(players.size() != 10){
            System.out.println("Enter name for player "+ players.size() + "(or type 'done' to finish)");
            name = scan.nextLine();
            if(name.equals("done")) break;
            players.add(new Player(name));
        }
        while(true){
            int die1 = (int)(Math.random() * 6 - 1) + 1;
            int die2 = (int)(Math.random() * 6 - 1) + 1;
            for(Player p : players){
                p.bet();
            }
            if(die1 == 1 && die2 == 1){
                System.out.println("The banker rolled 1-1! Banker loses! Players win!");
                for(int i = 0; i < players.size(); i++){
                    players.get(i).setChips(players.get(i).getBet() + players.get(i).getBet());
                }
            }
            System.out.println("The banker rolled "+die1+" and "+die2);
            for(Player p : players){
                p.roll(die1,die2);
            }
            System.out.println("Round over, each players chips: ");
            for(Player p : players){
                System.out.println(p.getName() + " | Chips = "+p.getChips());
                if(p.getChips() < 0){
                    System.out.println(p.getName()+ " lost all their money. They are out.");
                }
            }
        }
    }
}