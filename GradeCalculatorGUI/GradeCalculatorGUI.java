import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GradeCalculatorGUI{
    public static void startCalculate(){
        
        // setting the frame
        JFrame frame = new JFrame("Student Grade Calculator");
        frame.setSize(400,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));

        // setting title
        JLabel title = new JLabel("Student Grade Calculator");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial",Font.BOLD,20));
        title.setForeground(Color.RED);

        // setting subject numbers
        JLabel subjectLabel = new JLabel("---Enter the number of subjects---");
        subjectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // setting subject input
        JTextField subjectInput = new JTextField();
        subjectInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        subjectInput.setMaximumSize(new Dimension(150,30));

        // setting calculate button
        JButton button = new JButton("Calculate");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(150,30));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        // setting result
        JLabel result = new JLabel(" ");
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setFont(new Font("Arial",Font.PLAIN,16));

        // ADDING the components with spaces
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(title);

        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(subjectLabel);

        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(subjectInput);

        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(button);

        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(result);

        // calculate logic
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    int subjects = Integer.parseInt(subjectInput.getText());
                    if(subjects <=0){
                        result.setText("Enter a valid number of subjects");
                        return;
                    }
                    double totalMarks = 0;
                    for(int i=0;i<subjects;i++){
                        String marksInput = JOptionPane.showInputDialog(frame, "Enter marks of subject "+(i+1)+" (out of 100):");
                        double marks = Double.parseDouble(marksInput);
                        if(marks >= 0 && marks <=100){
                            totalMarks = totalMarks+marks;
                        }
                        else{
                            result.setText("Enter a valid subject number between 0-100");
                            return;
                        }
                    }

                    double avgPercentage = (double)(totalMarks/subjects);

                    String grade = null;

                    if (avgPercentage >= 90) grade = "O";
                    else if (avgPercentage >= 80) grade = "A+";
                    else if (avgPercentage >= 70) grade = "A";
                    else if (avgPercentage >= 60) grade = "B+";
                    else if (avgPercentage >= 50) grade = "B";
                    else if (avgPercentage >= 40) grade = "C";
                    else grade = "F";

                    result.setText("<html><center>Total Marks obtained: " + totalMarks +
                            "<br>Average: " + String.format("%.2f", avgPercentage) + "%" +
                            "<br>Grade: " + grade + "</center></html>");

                    



                }catch(Exception ex){
                    result.setText("Invalid input");
                }
            }
            
        });


        frame.setVisible(true);


    }
    public static void main(String[] args) {
        startCalculate();
    }
}