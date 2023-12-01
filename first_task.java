import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;    // Input




public class first_task {
    public static void main(String[] args) {

        int value;
        String name_of_the_file;

        System.out.println("Task 1\n\n");

        System.out.println("Please, input the name of the file:\n");

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        // take input from the user
        name_of_the_file = input.next();

        name_of_the_file = name_of_the_file + ".txt";

        try {
            FileWriter myWriter = new FileWriter(name_of_the_file); // creating new file

            System.out.println("\nWrite the number of integers you would like to write:\n");

            int num_of_integers = input.nextInt();

        
            while ( num_of_integers != 0){ // reading all numbers

                System.out.println("\nInput:\n"); // asking for user to input number

                value = input.nextInt(); // getting number

                num_of_integers -= 1; // counting input numbers

                myWriter.write(Integer.toString(value)); // writing the value to the file

                myWriter.write(" ");

            }

            myWriter.close(); // closig file

        } catch (IOException e) { // catching any errors
            System.out.println("An error occurred.");
            e.printStackTrace();
      
        }


        
    }
    
}