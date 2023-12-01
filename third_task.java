import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Scanner;    // Input




public class third_task {
    public static void main(String[] args) {

        System.out.println("Task 2\n\n");

        System.out.println("Input (1 - write | 2 - read | 3 - add to new text):\n");

        Scanner input = new Scanner(System.in);

        int answer = input.nextInt();

        if (answer == 1){

            writing_function();

        }else if (answer == 2){

            reading_function();

        }else{

            adding_funtion();

        }

    }


    public static void adding_funtion(){

        int value;

        ArrayList<String> data = collecting_reading();


        // create an object of Scanner
        Scanner input = new Scanner(System.in);


        try {
            FileWriter myWriter = new FileWriter("numbers.txt"); // creating new file


            for (String a : data) {

                myWriter.write(a);
                myWriter.write(" ");

            }

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

            System.out.println("\n\nDONE!\n\n");

        } catch (IOException e) { // catching any errors
            System.out.println("An error occurred.");
            e.printStackTrace();
      
        }




    }


    // collecting info from the previous version of the file
    public static ArrayList<String> collecting_reading() {

        ArrayList<String> arrOfStr = new ArrayList<>();

        try {

            File file = new File("numbers.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                for (String a : data.split(" ")){

                    arrOfStr.add(a);

                }

            }
            myReader.close();

            return arrOfStr;


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

            return arrOfStr;
        }

        
    }




    public static void writing_function(){

        int value;

        


        // create an object of Scanner
        Scanner input = new Scanner(System.in);


        try {
            FileWriter myWriter = new FileWriter("numbers.txt"); // creating new file

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

            System.out.println("\n\nDONE!\n\n");

        } catch (IOException e) { // catching any errors
            System.out.println("An error occurred.");
            e.printStackTrace();
      
        }

    }

    public static void reading_function() {

        int count;

        count = 1;

        try {
            File file = new File("numbers.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] arrOfStr = data.split(" ");

                for (String a : arrOfStr){
                    System.out.printf("Number %d : %s \n", count, a);
                    count += 1;
                }

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
