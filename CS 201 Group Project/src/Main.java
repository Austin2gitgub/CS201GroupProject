import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {//Enclosing inside a try catch block to catch exceptions
            int counter =21;

            //Reading the File
            String txtFilePath = "C:\\Users\\Austin\\Downloads\\Mock_data.txt";
            var ReaderObject = new BufferedReader(new FileReader(txtFilePath.toString())); //
            String line;

            //Creating a ArrayList
            var ListArrayVar = new ArrayList<String>();

            //Assigning the values inside the ArrayList
            while ((line = ReaderObject.readLine()) != null) {
                ListArrayVar.add(line);
            }

            //Cut the List and place it into a 2D Array
            var TwoDimdata = new String[ListArrayVar.size()][ListArrayVar.get(0).toString().split(",").length];
            for (var i = 0; i < TwoDimdata.length; i++) {
                for (var j = 0; j < TwoDimdata[0].length; j++) {
                    var arr = ListArrayVar.get(i).split(",");
                    TwoDimdata[i][j] = arr[j];
                }
            }

// Code for outputing 1st(Index wise) row of our 2D Array
//                for(int a=0;a<6;a++){
//
//                    System.out.print(TwoDimdata[1][a].toString()+", ");
//                }

            //Code to output all the rows in our 2D array
            //System.out.println(Arrays.deepToString(TwoDimdata).replace("], ", "]\n"));

            //Main Menu
            boolean mainMenuRepeatCheck = false;
            do {//Creating a Do while in-order to repeat 'do' when the input is not valid

                //Getting input from the user for Main Menu
                Scanner input = new Scanner(System.in);
                System.out.println("\n" + "           Welcome to the product management dashboard\n");
                System.out.println("1. Do you want to add an product? If so type '1'.");
                System.out.println("2. Do you want to search an product? If so type '2'.");
                System.out.println("3. Do you want to list an product based on category? If so type '3'.");
                System.out.println("4. Do you want to exit the dashboard? If so type 'Exit'.");

                String inputAction = input.next();

                //Validations to assign to the correct code operation ex: add product, etc.
                if (inputAction.equals("1")) {
                    boolean addProductRepeatCheck = false;
                    do {//Creating a Do while in-order to repeat 'do' when the input is not valid

                        //Getting the input from the user for adding the product
                        System.out.println("For 2 words or more give a '_' in between ex: Whole_Pepper");
                        System.out.println("What is the name?");
                        String nameInput = input.next();
                        input.nextLine();
                        System.out.println("What is the Category?");
                        String categoryInput = input.next();
                        System.out.println("What is the Type?");
                        String typeInput = input.next();
                        System.out.println("What is the Price(ex: $0.50)?");
                        String priceInput = input.next();
                        System.out.println("What is the Expiration(in days)?");
                        String expirationInput = input.next();
                        System.out.println("What is the Status(In-Store or Sold-Out)?");
                        String statusInput = input.next();

                        //Validation for null Input
                        if (nameInput.length() < 1 || categoryInput.length() < 1 || typeInput.length() < 1 || priceInput.length() < 1 || expirationInput.length() < 1 || statusInput.length() < 1) {
                            System.out.println("No Input or Partial Input, please type all inputs fully again!");
                            addProductRepeatCheck=true; //condition check for do while
                        } else {
                            counter++;//adding all the product values ie. name, etc. to below the last existing data
                            TwoDimdata[counter-1][0] = nameInput;
                            TwoDimdata[counter-1][1] = categoryInput;
                            TwoDimdata[counter-1][2] = typeInput;
                            TwoDimdata[counter-1][3] = priceInput;
                            TwoDimdata[counter-1][4] = expirationInput;
                            TwoDimdata[counter-1][5] = statusInput;

                            System.out.println("The product is successfully added");

                            System.out.println("If you want to add another product, type 1");
                            System.out.println("If you want to go to main menu, type 2");
                            boolean function1FinalDecisionRepeatCheck = false;
                            do {//Creating a Do while in-order to repeat 'do' when the input is not valid
                                String function1FinalDecision = input.next();
                                if (function1FinalDecision.equals("1")) {//Condition for changing do while
                                    addProductRepeatCheck = true;
                                } else if (function1FinalDecision.equals("2")) {//Condition for changing do while
                                    mainMenuRepeatCheck = true;
                                } else {//Condition for changing do while
                                    function1FinalDecisionRepeatCheck = true;
                                    System.out.println("Wrong Input, please try again!");
                                }
                            }
                            while(function1FinalDecisionRepeatCheck==true);
                        }
                    }
                    while (addProductRepeatCheck==true);


                } else if (inputAction.equals("2")) {
                    System.out.println(Arrays.deepToString(TwoDimdata).replace("], ", "]\n"));
                    //SearchItemInList();
                    //or
                    //Fill code for that here
                } else if (inputAction.equals("3")) {

                    //SearchItemByCategoryInList();
                    //or
                    //Fill code for that here
                } else if (inputAction.equals("Exit") || inputAction.equals("exit")) {
                    mainMenuRepeatCheck =false;
                    System.out.println("Thank you for using our dashboard");
                } else {
                    mainMenuRepeatCheck =true;
                    System.out.println("Wrong Input, please try again!");
                }
            }
            while (mainMenuRepeatCheck==true);

        }
        catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}