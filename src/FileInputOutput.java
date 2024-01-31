import java.io.*;
import java.util.Scanner;
public class FileInputOutput {

    public static void main(String[] args) {

//       1) Open the given file inside src called moviesDataSet.csv
//       2) Read each row in the dataset
//       3) Print each row to the screen
//       4) Print only the name of the movie
//       5) Add exception handling (try & catch) when needed
//       6) Close the files after finishing the processing
//       7) Commit your code and push it to the GitHub

        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("src/moviesDataset.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Could not open input file - ending program");
            System.exit(1);
        }
        Scanner fileReader = new Scanner(myFile);


        Scanner kb = new Scanner(System.in);
        System.out.print("Enter name for output file: ");
        String fileName = kb.nextLine();
        PrintWriter fileWriter;
        FileOutputStream myFile2 = null;
        try {
            myFile2 = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened for output- closing program");
            System.exit(1);
        } // ends catch
        fileWriter = new PrintWriter(myFile2);

        if (fileReader.hasNextLine()) {
            fileReader.nextLine();
        }
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            String[] year = data.split(",");
            try {
                 Integer.parseInt(year[4]);
                fileWriter.println(year[4]);
            }
            catch (NumberFormatException ex) {
                fileWriter.println("N/A");
            }
        }
        fileWriter.close();
        fileReader.close();
    }
}
//
//        }
//
//        fileReader.close();
//
//
//       FileInputStream myFile2 = null;
//       try {
//            myFile2 = new FileInputStream("src/moviesDataset.csv");
//        } catch (FileNotFoundException e) {
//            System.out.println("Could not open input file - ending program");
//           System.exit(1);
//       }
//
//       Scanner fileReader2 = new Scanner(myFile2);
//        while (fileReader2.hasNextLine()) {
//           String data2 = fileReader2.nextLine();
//            String[] movie = data2.split(",");
//            System.out.println(movie[2] + " ");
//        }
//        fileReader.close();
//    }
//}