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
            int counter =21;//used for add product feature to allow the system to place the new row after the last value contained row

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

            //Testing help:
            //Code to output all the rows in our 2D array
            //System.out.println(Arrays.deepToString(TwoDimdata).replace("], ", "]\n"));

            //Main Menu
            boolean mainMenuRepeatCheck = false;
            do {//Creating a Do while in-order to repeat 'do' when the input is not valid
                mainMenuRepeatCheck = false;
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
                    do {

                        System.out.println("\n");
                        addProductRepeatCheck = false;// this ensures this boolean does not just stay in true always
                        //Getting the input from the user for adding the product
                        System.out.println("For 2 words or more give a '_' in between ex: Whole_Pepper");
                        System.out.println("What is the name?");
                        String nameInput = input.next().toLowerCase();
                        input.nextLine();
                        System.out.println("What is the Category?");
                        String categoryInput = input.next().toLowerCase();
                        System.out.println("What is the Type?");
                        String typeInput = input.next().toLowerCase();
                        System.out.println("What is the Price(ex: $0.50)?");
                        String priceInput = input.next().toLowerCase();
                        System.out.println("What is the Expiration(in days)?");
                        String expirationInput = input.next().toLowerCase();
                        System.out.println("What is the Status(In-Store or Sold-Out)?");
                        String statusInput = input.next().toLowerCase();

                        System.out.println("\n");
                        //Validation for null Input
                        if (nameInput.length() < 1 || categoryInput.length() < 1 || typeInput.length() < 1 || priceInput.length() < 1 || expirationInput.length() < 1 || statusInput.length() < 1) {
                            System.out.println("No Input or Partial Input, please type all inputs fully again!");
                            addProductRepeatCheck=true; //condition check for do while
                        } else {

                            counter++;//adding all the product values ex. name, etc. to below the last existing data
                            TwoDimdata[counter-1][0] = nameInput;
                            TwoDimdata[counter-1][1] = categoryInput;
                            TwoDimdata[counter-1][2] = typeInput;
                            TwoDimdata[counter-1][3] = priceInput;
                            TwoDimdata[counter-1][4] = expirationInput;
                            TwoDimdata[counter-1][5] = statusInput;

                            System.out.println("\n");

                            System.out.println("The product is successfully added");

                            System.out.println("\n");
                            //Checking if the user wants to add another product or go to main menu
                            System.out.println("If you want to add another product, type 1");
                            System.out.println("If you want to go to main menu, type 2");
                            boolean function1FinalDecisionRepeatCheck = false;
                            do {//Creating a Do while in-order to repeat 'do' when the input is not valid
                                function1FinalDecisionRepeatCheck = false;
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
                            while(function1FinalDecisionRepeatCheck==true); //repeats do when the while condition is met
                        }
                    }
                    while (addProductRepeatCheck==true); //repeats do when the while condition is met


                } else if (inputAction.equals("2")) {
                    boolean searchProductRepeatCheck = false;
                    do {
                        System.out.println("\n");
                        searchProductRepeatCheck = false;
                        boolean foundCheck = false;

                        //Gets the product name from the user
                        System.out.println("For 2 words or more give a '_' in between ex: Whole_Pepper");
                        System.out.println("What is the name of the product you want to search?");
                        String productName = input.next();
                        System.out.println("\n");
                        //Lists rest of the product details of that product name
                        for (int i = 0; i < TwoDimdata.length - 1; i++) {
                            if (TwoDimdata[i][0].equals(productName.toLowerCase())) //we are using .toLowerCase() to take convert the input to lower case as our data set is also in lower case
                            {   foundCheck = true;
                                System.out.println(TwoDimdata[i][0] + ", " + TwoDimdata[i][1] + ", " + TwoDimdata[i][2] + ", " + TwoDimdata[i][3] + ", " + TwoDimdata[i][4] + ", " + TwoDimdata[i][5]);

                            }

                        }
                        if (foundCheck == false) {
                            System.out.println("No product is found");
                        } else {
                        }
                        System.out.println("\n");
                        //Checking if the user wants to search another product or go to main menu
                        System.out.println("If you want to search another product, type 1");
                        System.out.println("If you want to go to main menu, type 2");
                        boolean function2FinalDecisionRepeatCheck = false;
                        do {//Creating a Do while in-order to repeat 'do' when the input is not valid
                            function2FinalDecisionRepeatCheck = false;
                            String function2FinalDecision = input.next();
                            if (function2FinalDecision.equals("1")) {//Condition for changing do while
                                searchProductRepeatCheck = true;
                            } else if (function2FinalDecision.equals("2")) {//Condition for changing do while
                                mainMenuRepeatCheck = true;
                            } else {//Condition for changing do while
                                function2FinalDecisionRepeatCheck = true;
                                System.out.println("Wrong Input, please try again!");
                            }
                        }
                        while (function2FinalDecisionRepeatCheck == true);
                    }
                    while(searchProductRepeatCheck == true);
                } else if (inputAction.equals("3")) {
                    boolean categorizeProductRepeatCheck = false;
                    do {
                        System.out.println("\n");
                        categorizeProductRepeatCheck = false;
                        //Outputting all the categories in the data set
                        for (int i = 0; i < TwoDimdata.length - 1; i++) {
                            System.out.println(TwoDimdata[i][1]);
                        }

                        boolean categoryInputCheck = false;
                        do {
                            categoryInputCheck = false;

                            boolean categoryInputFromUserCheck = false;


                                categoryInputFromUserCheck = false;
                                //Asking the user to choose one category
                                System.out.println("\nFor 2 words or more give a '_' in between ex: Whole_Pepper");
                                System.out.println("Please choose one category");

                                String chooseCategory = input.next().toLowerCase();

                            System.out.println("\n");
                                //Listing all the product names for that chosen category
                                for (int a = 0; a < TwoDimdata.length - 1; a++) {
                                    if (TwoDimdata[a][1].equals(chooseCategory)) {

                                        System.out.println(TwoDimdata[a][0]);

                                    }

                                }

                            //Asking the user to choose from the listed product names for seeing all the details of it
                            System.out.println("Please chose the product name, you want to see details of");
                            String productDetailsInput = input.next().toLowerCase();

                            System.out.println("\n");
                            //Outputting all the product details for the select product name
                            for (int z = 0; z < TwoDimdata.length - 1; z++) {

                                if (TwoDimdata[z][0].equals(productDetailsInput)) {
                                    System.out.println(TwoDimdata[z][0] + ", " + TwoDimdata[z][1] + ", " + TwoDimdata[z][2] + ", " + TwoDimdata[z][3] + ", " + TwoDimdata[z][4] + ", " + TwoDimdata[z][5]);
                                }

                            }
                            System.out.println("\n");
                            //Checking if the user wants to list another category or go to main menu
                            System.out.println("If you want to list another category, type 1");
                            System.out.println("If you want to go to main menu, type 2");
                            boolean function3FinalDecisionRepeatCheck = false;
                            do {//Creating a Do while in-order to repeat 'do' when the input is not valid
                                function3FinalDecisionRepeatCheck = false;
                                String function3FinalDecision = input.next();
                                if (function3FinalDecision.equals("1")) {//Condition for changing do while
                                    categorizeProductRepeatCheck = true;
                                } else if (function3FinalDecision.equals("2")) {//Condition for changing do while
                                    mainMenuRepeatCheck = true;
                                } else {//Condition for changing do while
                                    function3FinalDecisionRepeatCheck = true;
                                    System.out.println("Wrong Input, please try again!");
                                }
                            }
                            while (function3FinalDecisionRepeatCheck == true);

                        }
                        while (categoryInputCheck == true);
                    }
                    while(categorizeProductRepeatCheck==true);
//

                }

                else if (inputAction.equals("Exit") || inputAction.equals("exit")) {
                    mainMenuRepeatCheck =false;
                    System.out.println("\nThank you for using our product management system, have a great day ahead");
                } else {
                    mainMenuRepeatCheck =true;
                    System.out.println("\nWrong Input, please try again!");
                }
            }
            while (mainMenuRepeatCheck==true);

        }
        //Catching exceptions for the buffered reader
        catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}