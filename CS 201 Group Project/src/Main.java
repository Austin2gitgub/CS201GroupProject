import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {//Enclosing inside a try catch block to catch exceptions

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

            //Cut the List and place it into the 2D Array
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
        }
        catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}