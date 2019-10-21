
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BackupPigGame {



        Scanner sc = new Scanner(System.in);


        public static void main(String[] args) {
            final int WIN_SCORE = 100;
            int numOfPlayers;
            Scanner sc = new Scanner(System.in);
            ArrayList<String> players = new ArrayList<String>();
            ArrayList<Integer> scores = new ArrayList<Integer>();

            do {
                System.out.println("How many players are there (1-2): ");
                numOfPlayers = sc.nextInt();
            } while (numOfPlayers < 1 || numOfPlayers > 3);
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.println("Enter player " + (i + 1) + "'s name");
                players.add(sc.next());
                scores.add(0);
            }
            for (int j = 0; j < players.size(); j++) {
                String name = players.get(j);
                int score = scores.get(j);
                int die1 = 0;
                char c;
                Random rand = new Random();

                System.out.println(name + " it's your turn. Your current score is " + score);
                System.out.println();

                do {
                    System.out.println("(R)oll the dice");
                    c = sc.next().charAt(0);
                } while (c != 'r' && c != 'R');

                for (int k = score; k < WIN_SCORE; k += die1) {

                    die1 = rand.nextInt(6) + 1;

                    System.out.println("You rolled a " + die1);
                    if (die1 == 1) {
                        System.out.println("-------YOU ROLLED A 1/ TURN OVER-------");
                        System.out.println();
                        break;
                    }else if ((k + die1) >= WIN_SCORE) {
                        scores.set(j, k + die1);
                        break;
                    }
                    System.out.println("Your current total is " + (k + die1));
                    do {
                        System.out.println("Would you like to (r)oll or (h)old");
                        c = sc.next().charAt(0);
                    } while (c != 'r' && c != 'R' && c != 'h' && c != 'H');
                    if (c == 'h' || c == 'H') {
                        scores.set(j, k + die1);
                        break;
                    }
                }
                if (scores.get(j) >= WIN_SCORE) {
                    System.out.println("Congratulations " + name + ", you won with " + scores.get(j) + " points!!!");
                    break;
                }else if (j==players.size()- 1){
                    j= -1;
                }
            }
        }
    }


