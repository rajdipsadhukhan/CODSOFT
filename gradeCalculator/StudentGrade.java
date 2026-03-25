import java.util.Scanner;
public class StudentGrade{

    public static void calculateGrade(Scanner sc){
        System.out.println("========================");
        System.out.println("Student Grade Calculator");
        System.out.println("========================");
        System.out.println("Enter number of subjects:");
        int subjects = sc.nextInt();
        int[] marks = new int[subjects];
        for(int i=0;i<subjects;i++){
            System.out.println("Enter marks of subject "+(i+1)+"(out of 100):");
            int input = sc.nextInt(); 
            if(input >=0 && input <=100){
                marks[i] = input;
            }
            else{
                System.out.println("invalid input");
            }
            
            
        }

        int totalMarks = 0;
        for(int i=0;i<marks.length;i++){
            totalMarks = totalMarks + marks[i];
        }

        double avgPercentage = (double)totalMarks / subjects;
        String grade = null;

        if(avgPercentage >=90){
            grade = "O";
        }else if(avgPercentage <90 && avgPercentage >=80){
            grade = "A+";
        }else if(avgPercentage <80 && avgPercentage >=70){
            grade = "A";
        }else if(avgPercentage <70 && avgPercentage >=60){
            grade = "B+";
        }else if(avgPercentage <60 && avgPercentage >=50){
            grade = "B";
        }else if(avgPercentage <50 && avgPercentage >=40){
            grade = "C";
        }else{
            grade = "F";
        }

        System.out.println("======Student Grade Card=======");
        System.out.println("Total marks of "+subjects+" subjects: "+totalMarks);
        System.out.printf("Average Percentage: %.2f\n" , avgPercentage);
        System.out.println("Grade: "+grade);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calculateGrade(sc);
        sc.close();
    }
}
