import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Scanner;    // Input


public class fourth_task {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("Input what you want to do ( 1 - add new student  | 2 - check data of the student ):\n\n");

        if (input.nextInt() == 1){

            add_student();

        }else{

            check_student();

        }
        


    }

    public static void add_student(){

        Scanner input = new Scanner(System.in);

        System.out.println("\n\nPlease, input the unique number of the student ( you will be able to find student by his number):\n\n");

        String name_of_the_file = Integer.toString(input.nextInt()) + ".txt";

        try {
            FileWriter myWriter = new FileWriter(name_of_the_file);

            System.out.println("\n\nInput name of the student:\n\n");
            String name = input.next();

            System.out.println("\n\nInput age of the student:\n\n");
            int age = input.nextInt();

            System.out.println("\n\nInput 0 if the student if full time and 1 if not:\n\n");
            int check = input.nextInt();
            String full_time = "";
            if (check == 0){
                full_time = "true";
            }else{
                full_time = "false";
            }

            System.out.println("\n\nInput mean mark of the student:\n\n");
            float mean_mark = input.nextFloat();

            myWriter.write(name);
            myWriter.write(" ");
            myWriter.write(Integer.toString(age));
            myWriter.write(" ");
            myWriter.write(full_time);
            myWriter.write(" ");
            myWriter.write(Float.toString(mean_mark));

            myWriter.close();

            System.out.println("Successfully wrote to the file.");
      
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
      
        }

    }


    public static void check_student(){

        Scanner input = new Scanner(System.in);

        System.out.println("\n\nPlease, input the unique number of the student:\n\n");

        String name_of_the_file = Integer.toString(input.nextInt()) + ".txt";

        try {
            File file = new File(name_of_the_file);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] arrOfStr = data.split(" ");

                System.out.printf("\n\n%s : %s\n\n", "Name", arrOfStr[0]);
                System.out.printf("\n\n%s : %s\n\n", "Age", arrOfStr[1]);
                System.out.printf("\n\n%s : %s\n\n", "Full-time", arrOfStr[2]);
                System.out.printf("\n\n%s : %s\n\n", "Mean-mark", arrOfStr[3]);

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }



}
