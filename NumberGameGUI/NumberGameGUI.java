import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGameGUI{
    static int randomNumber;
    static int guessRemained;

    public static void startGame(){
        randomNumber = (int)(Math.random()*50)+1;
        guessRemained = 10;


        // setting the frame
        JFrame frame = new JFrame("Number guessing Game");
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLayout(new FlowLayout());
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));

        
        

        JLabel title = new JLabel("Guess the numbers b/w 1-50");
        title.setFont(new Font("Arial",Font.BOLD,20));
        JTextField input = new JTextField(10);
        input.setMaximumSize(new Dimension(150, 30));
        input.setPreferredSize(new Dimension(150, 30));
        JButton guessButton = new JButton("Guess");
        guessButton.setMaximumSize(new Dimension(100, 30));
        JLabel result = new JLabel("You have 10 Chances");
        result.setHorizontalAlignment(SwingConstants.CENTER);
        JButton playAgainButton = new JButton("Play again");
        playAgainButton.setMaximumSize(new Dimension(120, 30));
        playAgainButton.setVisible(false);


        // setting alignments
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        input.setAlignmentX(Component.CENTER_ALIGNMENT);
        guessButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        // spacing b/w elements
        frame.add(Box.createRigidArea(new Dimension(0,20)));
        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0,20)));
        frame.add(input);
        frame.add(Box.createRigidArea(new Dimension(0,20)));
        frame.add(guessButton);
        frame.add(Box.createRigidArea(new Dimension(0,20)));
        frame.add(result);
        frame.add(Box.createRigidArea(new Dimension(0,20)));
        frame.add(playAgainButton);
        

        // setting bgc color of components
        guessButton.setBackground(Color.BLUE);
        guessButton.setForeground(Color.WHITE);

        playAgainButton.setBackground(Color.RED);
        playAgainButton.setForeground(Color.WHITE);

        // guessButton logic 
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    int userGuess = Integer.parseInt(input.getText());
                    if(userGuess < 1 || userGuess > 50){
                        guessRemained--;
                        result.setText("Enter a number b/w 1-50 and chances left "+guessRemained);
                        
                    }else if(userGuess < randomNumber){
                        guessRemained--;
                        result.setText("Entered number is too low compared to correct one, chances left "+guessRemained);
                        
                    }else if(userGuess > randomNumber){
                        guessRemained--;
                        result.setText("Entered number is too high compared to correct one, chances left "+guessRemained);
                       
                    }else{
                        int score = getScore(guessRemained);
                        result.setText("you guessed the correct number that is "+randomNumber+" and Score:"+score);
                        guessButton.setEnabled(false);
                        playAgainButton.setVisible(true);
                        return;
                    }

                    if(guessRemained == 0){
                        result.setText("<html>You lost!<br>Correct number: " + randomNumber + "<br>Score: " + getScore(guessRemained) + "</html>");
                        guessButton.setEnabled(false);
                        playAgainButton.setVisible(true);
                    }
                    
                }catch(Exception ex){
                    result.setText("Invalid input");
                }
            }
            
        });

        // playAgainButton
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                startGame();
            }
            
        });

        frame.setVisible(true);

    }

    // getScore
    public static int getScore(int guessRemained){
        if(guessRemained == 9) return 100;
        else if(guessRemained == 8) return 95;
        else if(guessRemained == 7) return 85;
        else if(guessRemained == 6) return 75;
        else if(guessRemained == 5) return 65;
        else if(guessRemained == 4) return 55;
        else if(guessRemained == 3) return 50;
        else if(guessRemained == 2) return 45;
        else if(guessRemained == 1) return 40;
        else return 0;
    }

    public static void main(String[] args) {
        startGame();
    }
}