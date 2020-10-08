import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static String[] arr; // ARRAY USED TO SPLIT STRING
    static ArrayList<String> grades = new ArrayList<>(); // ARRAYLIST STORES GRADES
    static ArrayList<String> weights = new ArrayList<>(); // ARRAYLIST STORES WEIGHTS
    static double weightsSum = 0.0; // SUM OF WEIGHTS

    public static void main (String[] args) {

        boolean running = true; // CREATE A COUNT TO KNOW HOW LONG THE ARRAY SHOULD BE
        int loopCount = 0; // KEEPS COUNT OF HOW MANY TIMES YOU INPUT
        double classGrade = 0.0; // OVERALL GRADE

        while (running) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter (grade, cat. wt.): "); // INPUT: (GRADE, CATEGORY WEIGHT %)
            String response = input.next();

            grades.add(stringSplit(response, ",")[0]); // ADD FIRST PART OF INPUT, GRADE
            weights.add(stringSplit(response, ",")[1]); // ADD SECOND PART OF INPUT, WEIGHT

            updateSum(loopCount); // UPDATE THE SUM USING loopCount (I.E. THE ELEMENT YOU JUST ADDED)
            System.out.println("Weights Sum: " + weightsSum);

            // YOUR CATEGORY WEIGHTS CANNOT EXCEED 100%!
            if (weightsSum > 100) {
                weights.remove(loopCount);
                System.out.println("Your weight % is greater than 100!");
            }

            System.out.println("Enter again? (true/false)");
            running = input.nextBoolean();

            loopCount++;
        }

        // FORMULA KEEPS GOING UNTIL THERE ARE NO ELEMENTS IN THE ARRAYLIST
        for (int i = 0; i < grades.size(); i++) {
            double temp = (Double.parseDouble(grades.get(i)) * Double.parseDouble(weights.get(i)) )/weightsSum;
            classGrade += temp;
        }

        System.out.println(classGrade);

    }

    public static String[] stringSplit (String word, String delimiter) {
        arr = word.split(delimiter); // DELIMITER INDICATES WHERE
        return arr;
    }
    public static void updateSum (int count) {
        weightsSum += Double.parseDouble((weights.get(count))); // COUNT PARAMATER USED IS loopCount
    }

}