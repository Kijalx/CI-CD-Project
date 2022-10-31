import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVFile {
    public void read(String path) {
        Scanner sc = null; // Sets up Scanner
        try { // Tries to get the file path
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // If it cant find it . it throws an exception
        }
        sc.useDelimiter(","); // Uses a comma to split the csv file using delimiter
        while (sc.hasNext()) { // This while loop prints until the file ends
            System.out.print(sc.next());
        }
        sc.close(); // Closes file
    }
}
