import java.util.Scanner;
public class NumberGame{
    public static void numberGame(Scanner sc){

        System.out.println("Number guessing game between 1-50 (10 chances):");
        int randomNumber = (int)(Math.random()*50)+1;
        int guessRemained = 10;
        System.out.println("Press 1 to play or 2 to exit");
        System.out.println("Enter your choice:");
        int wantToPlay = sc.nextInt();
        switch(wantToPlay){
            case 1:
                while(guessRemained > 0){
                    System.out.println("Guess the number you have "+guessRemained+" chances left");
                    System.out.println("enter your number:");
                    int userGuessed = sc.nextInt();

                    if(userGuessed <1 || userGuessed >50){
                        System.out.println("Enter a valid number between 1-50");
                    }
                    else if(userGuessed > randomNumber){
                        System.out.println("Entered number is too high compared with the correct one");
                    }else if(userGuessed < randomNumber){
                        System.out.println("Entered number is too low compared with the correct one");
                    }else if(userGuessed == randomNumber){
                        System.out.println("You guessed the correct number that is "+randomNumber);
                        break;
                    }
                    
                    guessRemained--;
                }
                if(guessRemained == 0){
                    System.out.println("You lost and the correct number is "+randomNumber);
                    System.out.println("Your score:"+0);
                }else if(guessRemained ==9){
                    System.out.println("Your score:"+100);
                }else if(guessRemained ==8){
                    System.out.println("Your score:"+95);
                }else if(guessRemained ==7){
                    System.out.println("Your score:"+85);
                }else if(guessRemained ==6){
                    System.out.println("Your score:"+75);
                }else if(guessRemained ==5){
                    System.out.println("Your score:"+65);
                }else if(guessRemained ==4){
                    System.out.println("Your score:"+55);
                }else if(guessRemained ==3){
                    System.out.println("Your score:"+50);
                }else if(guessRemained ==2){
                    System.out.println("Your score:"+45);
                }
                else if(guessRemained ==1){
                    System.out.println("Your score:"+40);
                }
                break;
                
            case 2:
                System.out.println("Exited successfully");
                break;
            
            default:
                System.out.println("Invalid option");
        }

        System.out.println("To play again enter PLAY and enter anything(except PLAY) to END:");
        
        sc.nextLine();
        String playAgain = sc.nextLine();
        if(playAgain.equals("PLAY")){
            playAgain(sc);
        }
        else{
            System.out.println("Exited successfully");
        }

    }
    public static void playAgain(Scanner sc){
        System.out.println("New Game:");
        numberGame(sc);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numberGame(sc);
    }
}
